package Model;

import Model.Exceptions.NoMoneyEx;

import java.io.Serializable;

public class BankAccount implements Serializable, Account {
    private double balance;
    private Owner owner;
    private int nrAccount; //dodany nr konta

   // public BankAccount(Owner owner) {
   //     this.owner = owner;
   // }
    public BankAccount(Owner owner) {this.owner=owner;}
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) { this.balance = balance; }
    public Owner getOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public int getNrAccount() {
        return nrAccount;
    }
    public void setNrAccount(int nrAccount) {
        this.nrAccount = nrAccount;
    }
    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) throws NoMoneyEx {
        try {
            if (this.balance-amount<0) {  //błąd jeśli po wybraniu miałby być ujemny balans
                throw new NoMoneyEx();
            }
            else {this.balance -= amount;}
        } catch (NoMoneyEx e) {
            System.out.println(e.getMessage());;
            throw e;
        }
    }
}
