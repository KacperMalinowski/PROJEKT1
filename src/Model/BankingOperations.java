package Model;

import Model.Exceptions.NoMoneyEx;

public interface BankingOperations {
    void deposit(int nrAccount, double amount);
    void withdraw(int nrAccount, double amount) throws NoMoneyEx;
    void transfer(int nrAccountFrom, int nrAccountTo, double amount) throws NoMoneyEx;
}
