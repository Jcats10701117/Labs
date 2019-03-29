package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class EmployeeFactory {
    private final PersonFactory personFactory;
    public EmployeeFactory() {
        personFactory = new PersonFactory();
    }
    public Employee createEmployee(String jobName) {
        Job job = new Job(jobName, StaticResources.getSalary());
        Person person = personFactory.createPerson();
        return new Employee(person, job, StaticResources.getEfficiency());
    }

    public ProjectManager createProjectManager() {
        Person person = personFactory.createPerson();
        return new ProjectManager(person);
    }

    public Customer createCustomer() {
        Person person = personFactory.createPerson();
        return new Customer(person);
    }
}
