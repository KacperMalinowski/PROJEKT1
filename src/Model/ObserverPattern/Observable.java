package Model.ObserverPattern;

import Model.BankAccount;

public interface Observable {
    void addObserverOffice(ObserverOffice observer);
    void deleteObserverOffice(ObserverOffice observer);
    void notifyObserverOffice(ObserverOffice observerOffice, BankAccount bankAccount, double amount );
}
