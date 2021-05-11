package Model.ObserverPattern;

import Model.BankAccount;

public interface ObserverOffice {
    void update(BankAccount bankaccount, double Amount);
}
