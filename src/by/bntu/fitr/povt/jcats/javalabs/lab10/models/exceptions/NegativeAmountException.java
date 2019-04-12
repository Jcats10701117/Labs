package by.bntu.fitr.povt.jcats.javalabs.lab10.models.exceptions;

public class NegativeAmountException extends Exception {
    public NegativeAmountException(int value) {
        super("BankAccount can not be negative \n" +
                String.format("Actual bankAccount: %d, ", value));
    }
}
