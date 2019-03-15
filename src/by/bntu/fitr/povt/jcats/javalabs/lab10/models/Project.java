package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Project {
    private final HandMadeList<Employee> employee;

    public final String name;
    public final Application application;
    public final Order order;

    public Project(Order order, Application application) {
        this.name = order.projectName;
        this.application = application;
        this.order = order;
        employee = new HandMadeList<>();
    }

    public boolean isComplete() {
        return application.getReadiness() == 1;
    }
}
