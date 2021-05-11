package Model;

import Model.Exceptions.NoMoneyEx;
import Model.ObserverPattern.Observable;
import Model.ObserverPattern.ObserverOffice;
import Model.Offices.TaxOffice;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable, BankingOperations, Observable {
    public ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    public ArrayList<ObserverOffice> observerOffices = new ArrayList<ObserverOffice>(); //lista taxOffice, referencja do obserwujących
    public Bank(ArrayList accounts) {
        this.accounts = accounts;
    }
    public ArrayList<BankAccount> getAccounts(){return accounts;}
    public Bank()
    {
        observerOffices.add(new TaxOffice()); //przechowuje referencje do TaxOffice
    }
    @Override
    public void deposit(int nrAccount, double amount) {
        this.accounts.get(nrAccount).deposit(amount);
        if (amount>50000) {
            for (int i=0; i<observerOffices.size();i++){
                this.notifyObserverOffice(observerOffices.get(i),accounts.get(nrAccount),amount);
            }
        }
    }

    @Override
    public void withdraw(int nrAccount, double amount) throws NoMoneyEx {
        this.accounts.get(nrAccount).withdraw(amount);
        if (amount>50000) {
            for (int i=0; i<observerOffices.size();i++){
                this.notifyObserverOffice(observerOffices.get(i),accounts.get(nrAccount),amount);
            }
        }
    }

    @Override
    public void transfer(int nrAccountFrom, int nrAccountTo, double amount) throws NoMoneyEx{
        this.accounts.get(nrAccountFrom).withdraw(amount);
        if (amount>50000) {
            for (int i=0; i<observerOffices.size();i++){
                this.notifyObserverOffice(observerOffices.get(i),accounts.get(nrAccountFrom),amount);
            }//wykorzystuje wybranie
        this.accounts.get(nrAccountTo).deposit(amount);  }  //i wpłacenie
        /*try {
            //if(this.accounts.get(nrAccountFrom).getBalance() - amount < 0) {throw new NoMoneyEx();}  //błąd jeśli po transferze miałby być ujemny balans
            this.accounts.get(nrAccountFrom).withdraw(amount);  //wykorzystuje wybranie
            this.accounts.get(nrAccountTo).deposit(amount);    //i wpłacenie
        } catch(NoMoneyEx e) {
            System.out.println(e.getMessage());;
        }
*/

    }

    @Override
    public void addObserverOffice(ObserverOffice observer) {
        observerOffices.add(observer);
    } //do arraylisty taxOffice dodajemy obserwatora

    @Override
    public void deleteObserverOffice(ObserverOffice observer) {
        observerOffices.remove(observer);
    } //z arraylisty taxOffice usuwamy obserwatora
    @Override
    public void notifyObserverOffice(ObserverOffice observerOffice, BankAccount bankAccount, double amount ) {
        observerOffice.update(bankAccount, amount);
        }
    }


