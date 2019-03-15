package by.bntu.fitr.povt.jcats.javalabs.lab10.models;
import java.util.Random;

public class DeveloperPlatform {
    private HandMadeList<Order> orders;

    public DeveloperPlatform() { orders = new HandMadeList<>(); }

    public void addOrder(Order order) { orders.add(order); }

    public Order getOrder() {
        Order order = orders.elementAt(new Random().nextInt(orders.size()));

        orders.remove(order);

        return order;
    }
}
