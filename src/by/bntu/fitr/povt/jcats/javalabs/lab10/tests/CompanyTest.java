package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;
import by.bntu.fitr.povt.jcats.javalabs.lab10.models.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CompanyTest {
    @Test
    public void completeOrder() {
        DeveloperPlatform developerPlatform = new DeveloperPlatform();
        Company company = new Company("SomeName", new EmployeeFactory(), developerPlatform);
        Customer customer = new Customer(new Person("SomeName", 20), developerPlatform);
        customer.makeOrder("SomeProject", "SomeApp", 200, new String[]{"design"});
        while (!company.currentProjects.iterator().next().application.isComplete()) {
            company.startWorkDay();

        }
        assertEquals(company.getBankAccount().getBalance(), 200);
    }


}
