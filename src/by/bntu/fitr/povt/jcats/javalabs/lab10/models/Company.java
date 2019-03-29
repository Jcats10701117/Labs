package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Arrays;
import java.util.Collection;

public class Company {
    public Company(String name, EmployeeFactory employeeFactory, DeveloperPlatform developerPlatform) {
        this.name = name;
        this.employeeFactory = new EmployeeFactory();
        employee = new HandMadeList<>();
        teams = new HandMadeList<>();
        currentProjects = new HandMadeList<>();
        projectManagers = new HandMadeList<>();
        availableEmployee = new HandMadeList<>();
        orders = new HandMadeList<>();
        developerPlatform.addCompany(this);
    }
    public final String name;
    private int companyCash;
    private Collection<Employee> employee;
    private Collection<Employee> availableEmployee;
    private Collection<Team> teams;
    private Collection<ProjectManager> projectManagers;
    private Collection<Project> currentProjects;
    private Collection<Order> orders;
    private EmployeeFactory employeeFactory;

    public int getCompanyCash() {
        return companyCash;
    }

    private int takeCash(int sum) {
        if (sum > companyCash) {
            var result = companyCash;
            companyCash = 0;
            return result;
        }
        companyCash -= sum;
        return sum;
    }

    private void paySalary(Employee employee){
        employee.pay(takeCash(employee.job.salary));
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

    private ProjectManager getFreeProjectManager() {
        for (var pManager: projectManagers) {
            if (pManager.getCurrentProject() == null){
                return pManager;
            }
        }

        var pManager = employeeFactory.createProjectManager();

        projectManagers.add(pManager);

        return pManager;
    }

    private void completeOrder(Project project) {
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

        companyCash += profit;

        for (var teammate: projectManager.getCurrentTeam().getTeammates()) {
            paySalary(teammate);
        }

        removeTeam(projectManager.getCurrentTeam());

        projectManager.setCurrentTeam(null);
        projectManager.setCurrentProject(null);

    }

    private void employ(Employee employee) {
        this.employee.add(employee);
        this.availableEmployee.add(employee);
    }

    private Team addTeam(Project project) {
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

    private Collection<String> getRequirements(Project project) {
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
}
