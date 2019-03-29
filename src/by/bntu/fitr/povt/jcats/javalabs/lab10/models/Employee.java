package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Employee {
    public final Person person;
    public final Job job;
    public final double efficiency;

    public Employee(Person person, Job job, double efficiency) {
        this.person = person;
        this.job = job;
        this.efficiency = efficiency;
    }

    public void completeWork(Application application) {
        for (ApplicationPart part: application.parts){
            if (part.name.equals(job.name)){
                part.complete(efficiency);
            }
        }
    }

    public void pay(int cash) {
        person.giveCash(cash);
    }
}
