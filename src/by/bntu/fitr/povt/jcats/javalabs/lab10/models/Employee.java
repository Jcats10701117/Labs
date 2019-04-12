package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Employee implements IPayer{
    public final Person person;
    public final Job job;
    public final double efficiency;
    private final BankAccount bankAccount;

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public Employee(Person person, Job job, double efficiency) {
        this.person = person;
        this.job = job;
        this.efficiency = efficiency;
        this.bankAccount = new BankAccount();
    }

    public void completeWork(Application application) {
        for (ApplicationPart part: application.parts){
            if (part.name.equals(job.name)){
                part.complete(efficiency);
            }
        }
    }
}
