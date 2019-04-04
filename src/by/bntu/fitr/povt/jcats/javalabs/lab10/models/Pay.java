package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Pay {
    public final int sum;
    public final IPayer from;
    public final IPayer to;

    public Pay(IPayer from, IPayer to, int sum) {
        this.from = from;
        this.to = to;
        this.sum = sum;
    }

    public boolean perform() {
        if (from.getBalance() < sum) {
            return false;
        }

        var amount = from.takeCash(sum);
        to.giveCash(amount);

        return true;
    }
}
