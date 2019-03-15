package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Customer {
    private final Person person;

    public Person getPerson() {
        return person;
    }

    public Customer(Person person) {
        this.person = person;
    }

    public int takeAwayOrder(Project project) {
        if (project.application.isComplete()) {
            return project.order.cost;
        }
        return 0;
    }
}
