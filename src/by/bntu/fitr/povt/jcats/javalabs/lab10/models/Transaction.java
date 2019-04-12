package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.exceptions.NegativeAmountException;
import by.bntu.fitr.povt.jcats.javalabs.lab10.models.exceptions.NotEnoughCashException;

public class Transaction {
    public final int sum;
    public final BankAccount from;
    public final BankAccount to;

    public Transaction(IPayer from, IPayer to, int sum) {
        this.from = from.getBankAccount();
        this.to = to.getBankAccount();
        this.sum = sum;
    }

    public boolean perform() {
        try {
            var amount = from.takePayment(sum);
            to.acceptPayment(amount);
        } catch (NotEnoughCashException exc) {
            return false;
        } catch (NegativeAmountException exc) {
            return false;
        }
        return true;
    }
}
