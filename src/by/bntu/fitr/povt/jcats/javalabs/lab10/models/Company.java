package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Arrays;
import java.util.Collection;

class DayCounter {
    private int dayAmount;
    private int currentDay;
    public boolean isRegularDay() { return dayAmount == currentDay; }
    public DayCounter(int dayAmount) {
        this.dayAmount = dayAmount;
    }
    public void nextDay() {
        if (++currentDay == dayAmount) {
            currentDay = 0;
        }
    }
}

public class Company implements IPayer {
    public Company(String name, EmployeeFactory employeeFactory, DeveloperPlatform developerPlatform) {
        this.name = name;
        this.employeeFactory = new EmployeeFactory();
        employee = new HandMadeList<>();
        teams = new HandMadeList<>();
        currentProjects = new HandMadeList<>();
        projectManagers = new HandMadeList<>();
        availableEmployee = new HandMadeList<>();
        orders = new HandMadeList<>();
        companyBankAccount = new BankAccount();
        dayCounter = new DayCounter(7);
        developerPlatform.addCompany(this);
    }

    public Transaction amount;
    public final String name;
    public final BankAccount companyBankAccount;
    public Collection<Employee> employee;
    public Collection<Employee> availableEmployee;
    public Collection<Team> teams;
    public Collection<ProjectManager> projectManagers;
    public Collection<Project> currentProjects;
    public Collection<Order> orders;
    public EmployeeFactory employeeFactory;
    public DayCounter dayCounter;

    public void paySalary (){
        employee.forEach(employee -> new Transaction(this, employee, employee.job.salary));
    }

    public void takeOrder(Order order) {
        var project = new Project(order);
        var pManager = getFreeProjectManager();
        var team = addTeam(project);

        pManager.setCurrentProject(project);
        pManager.setCurrentTeam(team);

        currentProjects.add(project);
        orders.add(order);
    }

    public ProjectManager getFreeProjectManager() {
        for (var pManager: projectManagers) {
            if (pManager.getCurrentProject() == null){
                return pManager;
            }
        }

        var pManager = employeeFactory.createProjectManager();

        projectManagers.add(pManager);

        return pManager;
    }

    public void completeOrder(Project project) {
        Order order = null;
        ProjectManager projectManager = null;

        for (var o: orders) {
            if (o.projectName.equals(project.name)) {
                order = o;
                break;
            }
        }

        for (var pM: projectManagers) {
            if (pM.getCurrentProject() == project) {
                projectManager = pM;
            }
        }

        var profit = order.customer.takeAwayOrder(project);

        removeTeam(projectManager.getCurrentTeam());

        projectManager.setCurrentTeam(null);
        projectManager.setCurrentProject(null);

    }

    public void employ(Employee employee) {
        this.employee.add(employee);
        this.availableEmployee.add(employee);
    }

    public Team addTeam(Project project) {
        Team team = new Team();

        var requirements = getRequirements(project);

        for (var jobName: requirements) {
            var newEmployee = employeeFactory.createEmployee(jobName);
            employ(newEmployee);
        }

        for (var req: requirements) {
            for (var emp: availableEmployee) {
                if (emp.job.name.equals(req)) {
                    team.addTeammate(emp);
                    break;
                }
            }
        }

        teams.add(team);

        return team;
    }
    private void removeTeam(Team team) {
        availableEmployee.addAll(Arrays.asList(team.getTeammates()));
        teams.remove(team);
    }

    public Collection<String> getRequirements(Project project) {
        HandMadeList<String> employeeOpportunities = new HandMadeList<>();
        HandMadeList<String> employeeRequirements = new HandMadeList<>();

        for (var e: availableEmployee) {
            employeeOpportunities.add(e.job.name);
        }

        for (var part: project.application.parts) {
            boolean contains = false;
            for (String opp: employeeOpportunities) {
                if (part.name.equals(opp)) { contains = true; }
            }
            if (!contains) {
                employeeRequirements.add(part.name);
            }
        }
        return employeeRequirements;
    }

    public void startWorkDay() {
        for (var pM: projectManagers) {
            pM.startWorkDay();
        }
        for (var pr: currentProjects) {
            if (pr.isComplete()) {
                completeOrder(pr);
            }
        }
    }

    public BankAccount getBankAccount() {
        return companyBankAccount;
    }
}
