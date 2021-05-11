package Model;

import Model.Exceptions.NoMoneyEx;

public interface Account {
    void deposit(double amount);
    void withdraw(double amount) throws NoMoneyEx;
}
