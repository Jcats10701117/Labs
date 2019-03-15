package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Random;

public class EmployeeFactory {
    Random random = new Random();

    public Employee createEmployee(Person person, String jobName) {
        Job job = new Job(jobName, StaticResources.getSalary());
        return new Employee(person, job, StaticResources.getEfficiency());
    }
}
