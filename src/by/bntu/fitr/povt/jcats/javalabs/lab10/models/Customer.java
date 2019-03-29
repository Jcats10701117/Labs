package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Collection;

public class Customer {
    private final Person person;
    private Collection<Order> orders;
    private DeveloperPlatform developerPlatform;

    public Person getPerson() {
        return person;
    }

    public Customer(Person person, DeveloperPlatform developerPlatform) {
        this.person = person;
        orders = new HandMadeList<>();
        this.developerPlatform = developerPlatform;
    }

    public int takeAwayOrder(Project project) {
        Order order = null;
        for (var o: orders) {
            if (project.name.equals(o.projectName)) {
                order = o;
            }
        }

        if (project.isComplete()) {
            return order.cost;
        }

        return 0;
    }

    public void makeOrder(String projectName, String appName, int cost, String[] appPartsNames) {
        var order = new Order(projectName, appName, this, cost, appPartsNames);
        orders.add(order);
        developerPlatform.publishOrder(order);
    }
}
