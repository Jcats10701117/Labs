package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Order {
    public final String projectName;
    public final String appName;
    public final String[] appPartsNames;
    public final Customer customer;
    public final int cost;
    public Order(String projectName, String appName, Customer customer, int cost, String ... appPartsNames) {
        this.appName = appName;
        this.projectName = projectName;
        this.appPartsNames = appPartsNames;
        this.customer = customer;
        this.cost = cost;
    }
}
