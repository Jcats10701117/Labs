package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public class Cash {

    private class NotEnoughCashException extends Exception {
        public NotEnoughCashException(int actual, int sum) {
            super("Payer has not enough cash \n" +
                    String.format("Actual balance: %d", actual) +
                    String.format("Required sum: %d", sum));
        }
    }

    private class NegativeAmountException extends Exception {
        public NegativeAmountException(Amount amount) {
            super("Cash can not be negative \n" +
                    String.format("Actual cash: %d, ", amount.value));
        }
    }
    private int cash;
    public void giveCash(Amount amount) throws NegativeAmountException{
        if (amount.value < 0) {
            // TODO make amount exception
            throw new NegativeAmountException(amount);
        }

        cash += amount.value;
    }
    public Amount takeCash(int size) throws NotEnoughCashException {

        if (size >= this.cash) {
            throw new NotEnoughCashException(cash, size);
        }

        this.cash -= size;
        return new Amount(size);
    }

    public int getBalance() {
        return cash;
    }


}
