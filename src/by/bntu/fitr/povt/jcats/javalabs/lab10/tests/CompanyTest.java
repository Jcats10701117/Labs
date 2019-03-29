//package by.bntu.fitr.povt.jcats.javalabs.lab10.tests;
//import by.bntu.fitr.povt.jcats.javalabs.lab10.models.*;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class CompanyTest {
//
//    @Test
//    public void takeOrder() {
//        ProjectManager projectManager = new ProjectManager(new Person("SameName", 20));
//        Company company = new Company("Somename");
//        Customer customer = new Customer(new Person("SomePerson", 20));
//        Order order = new Order("SomeProject", "SomeApp", customer, 2000, new String[]{"Design"});
//        company.takeOrder(order);
//        assertEquals(company.getCurrentOrder(), order);
//    }
//
//    @Test
//    public void completeOrder() {
//        ProjectManager projectManager = new ProjectManager(new Person("SameName", 20));
//        Company company = new Company("SomeName", projectManager);
//        Customer customer = new Customer(new Person("SomeName", 20));
//        Order order = new Order("SomeProject", "SomeApp", customer, 200, new String[]{"design"});
//        int expectedCost = order.cost;
//        assertEquals(expectedCost, company.getCompanyCash());
//
//    }
//
//    @Test
//    public void createProject() {
//        ProjectManager projectManager = new ProjectManager(new Person("SomePerson", 20));
//        Company company = new Company("SomeCompany", projectManager);
//        Customer customer = new Customer(new Person("SomePerson", 20));
//        Order order = new Order("SomeProject", "SomeApp", customer, 2000, new String[]{"Design"});
//        company.takeOrder(order);
//        assertNotNull(company.getCurrentProject());
//        String expectedName = "SomeProject";
//        assertEquals(expectedName, company.getCurrentProject().name);
//    }
//
//    @Test
//    public void canGetCompanyRequirements() {
//        ProjectManager projectManager = new ProjectManager(new Person("SomePerson", 20));
//        Company company = new Company("SomeCompany", projectManager);
//        company.employ(
//                new Employee(
//                        new Person("SomePerson", 20),
//                        new Job("Design", 2000), 0.1));
//        Customer customer = new Customer(new Person("SomePerson", 20));
//        Order order = new Order(
//                "SomeProject",
//                "SomeApp",
//                customer,
//                2000,
//                new String[]{"Design", "Program", "Mobile"});
//        company.takeOrder(order);
//
//        HandMadeList<String> actual = company.getRequirements();
//        String[] actualArray = new String[actual.size()];
//        for (int i = 0; i < actual.size(); i++){
//            actualArray[i] = actual.elementAt(i);
//        }
//        String[] expected = {"Program", "Mobile"};
//
//        assertArrayEquals(expected, actualArray);
//    }
//}
