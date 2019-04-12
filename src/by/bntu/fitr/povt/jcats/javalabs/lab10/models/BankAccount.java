package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

import by.bntu.fitr.povt.jcats.javalabs.lab10.models.exceptions.NegativeAmountException;
import by.bntu.fitr.povt.jcats.javalabs.lab10.models.exceptions.NotEnoughCashException;

public class BankAccount {


    private int cash;

    public void acceptPayment(int amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }
        cash += amount;
    }

    public int takePayment(int size) throws NotEnoughCashException {
        if (size >= this.cash) {
            throw new NotEnoughCashException(cash, size);
        }
        this.cash -= size;
        return size;
    }

    public int getBalance() {
        return cash;
    }


}
