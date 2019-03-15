package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import java.util.Random;

public class StaticResources {
    private static final Random random = new Random();

    private static final String[] personNames = {
            "Joe",
            "Mike",
            "Andrew",
            "John",
            "Shone",
            "Virgil"
    };

    private static final String[] companyNames = {
            "Itransition",
            "Epam",
            "ITCart",
            "Lovata",
            "Raizlabs",
            "Bigdrop"
    };

    private static final String[] jobNames = {
            "Frontend",
            "Backend",
            "Mobile",
            "Design",
            "Content"
    };

    public static String getPersonName() {
        return personNames[random.nextInt(personNames.length)];
    }

    public static String getCompanyName() {
        return personNames[random.nextInt(personNames.length)];
    }

    public static String getJobName() {
        return jobNames[random.nextInt(jobNames.length)];
    }

    public static int getAge() {
        return 18 + random.nextInt(10);
    }

    public static int getSalary() {
        return 100 + random.nextInt(400);
    }

    public static double getEfficiency() {
        return (1 + random.nextInt(4)) / 10.0;
    }
}
