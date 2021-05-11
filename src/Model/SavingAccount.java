package Model;

import Model.BankAccount;
import Model.Owner;

public class SavingAccount extends BankAccount {
    private double interest;
    public SavingAccount(Owner owner, double interest) {
        super(owner);
        this.interest = interest;
    }
    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }
}
