package by.bntu.fitr.povt.jcats.javalabs.lab10.models;

public interface IPayer {
    void giveCash(Amount amount);
    Amount takeCash(int sum);
    int getBalance();

}
