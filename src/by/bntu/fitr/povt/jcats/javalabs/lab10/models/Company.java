package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Company {
    public final String name;

    public final ProjectManager projectManager;

    public Order getCurrentOrder() {
        return currentOrder;
    }

    private Order currentOrder;

    public Project getCurrentProject() {
        return currentProject;
    }

    private Project currentProject;
    private HandMadeList<Employee> employee;

    public int getCompanyCash() {
        return companyCash;
    }

    private int companyCash;

    public Company(String name, ProjectManager projectManager) {
        this.name = name;
        this.projectManager = projectManager;
        employee = new HandMadeList<>();
    }

    public void takeOrder(Order order) {
        this.currentOrder = order;
        createProject();
    }

    public void completeOrder() {
        companyCash += currentOrder.customer.takeAwayOrder(currentProject);
        currentOrder = null;
        currentProject = null;
    }

    public void employ(Employee ... employee) {
        for (Employee e: employee){
            this.employee.add(e);
        }
    }

    public HandMadeList<String> getRequirements() {
        HandMadeList<String> employeeOpportunities = new HandMadeList<>();
        HandMadeList<String> employeeRequirements = new HandMadeList<>();

        for (Employee e: employee) {
            employeeOpportunities.add(e.job.name);
        }

        for (ApplicationPart part: currentProject.application.parts) {
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

    public void createProject() {

        HandMadeList<ApplicationPart> applicationParts = new HandMadeList<>();

        for (String name: currentOrder.appPartsNames) {
            applicationParts.add(new ApplicationPart(name));
        }

        Application application = new Application(currentOrder.appName, applicationParts);

        currentProject = new Project(currentOrder, application);
    }
}
