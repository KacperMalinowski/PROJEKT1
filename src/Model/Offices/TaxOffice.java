package Model.Offices;

import Model.Bank;
import Model.BankAccount;
import Model.ObserverPattern.ObserverOffice;
import Model.Owner;

import java.io.Serializable;

public class TaxOffice implements Serializable, ObserverOffice {
    BankAccount bankAccount;

    public void raport(BankAccount bankAccount, double Amount) {
        Owner owner= bankAccount.getOwner();
        System.out.println("Podejrzana aktywność: \nImię: "+owner.getName()+"\nNazwisko: "+owner.getSurname()+"\nKwota: "+ Amount+" zł\n");
    }

    @Override
    public void update(BankAccount bankAccount, double Amount) {
        raport(bankAccount, Amount);
    }
    }

