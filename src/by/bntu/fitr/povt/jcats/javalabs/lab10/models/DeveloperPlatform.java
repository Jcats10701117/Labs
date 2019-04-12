package by.bntu.fitr.povt.jcats.javalabs.lab10.models;
import java.util.Collection;
import java.util.Random;

public class DeveloperPlatform {
    private Collection<Company> companies;
    private Random random;
    public DeveloperPlatform() {
        companies = new HandMadeList<>();
        random = new Random();
    }
    public void addCompany(Company company) {
        companies.add(company);
    }
    public void publishOrder(Order order) {
        if (companies.isEmpty()) return;
        var company = (Company)companies.toArray()[random.nextInt(companies.size())];
        company.takeOrder(order);
    }
}
