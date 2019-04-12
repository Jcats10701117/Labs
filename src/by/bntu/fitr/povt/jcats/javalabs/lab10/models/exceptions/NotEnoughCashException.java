package by.bntu.fitr.povt.jcats.javalabs.lab10.models.exceptions;

public class NotEnoughCashException extends Exception {
    public NotEnoughCashException(int actual, int sum) {
        super("Payer has not enough bankAccount \n" +
                String.format("Actual balance: %d", actual) +
                String.format("Required sum: %d", sum));
    }
}
