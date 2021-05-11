package Controller;
import Model.Bank;
import Model.BankAccount;
import Model.Exceptions.NoMoneyEx;
import Model.Exceptions.NrAccountEx;
import Model.Offices.TaxOffice;
import Model.Owner;
import Model.SavingAccount;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class BusinessLogic {
    private Bank bank;
    private IOBank ioBank = new IOBank();

    public BusinessLogic(Bank bank)
    {
        this.bank=bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public BankAccount addNewAccount(Owner owner) {
        /*BankAccount account = new BankAccount(owner,0);
        try{
        //this.bank.accounts.add(account);
        bank.getAccounts().add(account);
    }
        catch (NullPointerException e){e.getMessage();}
        return account;*/
        Random random = new Random();
        int newAccountId = random.nextInt(999999+1-100000)+100000 /*(int)(Math.random()*10000)*/;
        BankAccount account = new BankAccount(owner);
        account.setNrAccount(newAccountId);
        this.bank.accounts.add(account);
        return account;
    }

    private int getAccount(int nrAccount) throws NrAccountEx{
        ArrayList<BankAccount> accounts=this.bank.accounts;
        for(int index=0;index<accounts.size();index++){
            BankAccount bankAccount=accounts.get(index);
            if(bankAccount.getNrAccount()==nrAccount){
                return index;
            }
        } throw new NrAccountEx();
    }

    public SavingAccount addNewAccount(Owner owner, double interest) {
        /*BankAccount account = new BankAccount(owner,0);
        try{
        //this.bank.accounts.add(account);
        bank.getAccounts().add(account);
    }
        catch (NullPointerException e){e.getMessage();}
        return account;*/
        Random random = new Random();
        int newAccountId = random.nextInt(999999+1-100000)+100000 /*(int)(Math.random()*10000)*/;
        SavingAccount account = new SavingAccount(owner, interest);
        account.setNrAccount(newAccountId);
        this.bank.accounts.add(account);
        return account;
    }

    public void deposit(int nrAccount, double amount) throws NrAccountEx {
        this.bank.deposit(getAccount(nrAccount), amount);
        /*try {
            int index = 0;
            for (BankAccount bankAccount : this.bank.accounts) {
                if (bankAccount.getNrAccount() == nrAccount) {
                    this.bank.deposit(index, amount);
                }
                else throw new NrAccountEx();
                index++;
            } //TO.raport(index, amount);
        } catch (NrAccountEx e) {
            System.out.println(e.getMessage());
        }*/
    }

    public void withdraw(int nrAccount, double amount) throws NrAccountEx, NoMoneyEx {
        this.bank.withdraw(getAccount(nrAccount), amount);
        /*try {
            int index = 0;
            for (BankAccount bankAccount : this.bank.accounts) {
                if (bankAccount.getNrAccount() == nrAccount) {
                    this.bank.withdraw(index, amount);
                }//TO.raport(index, amount);
                else throw new NrAccountEx();
                index++;
            }
        } catch (NrAccountEx e) {
            System.out.println(e.getMessage());
        }*/
    }

    public void transfer(int nrAccountFrom, int nrAccountTo, double amount) throws NrAccountEx, NoMoneyEx {
        this.bank.transfer(getAccount(nrAccountFrom),getAccount(nrAccountTo),amount);
        /*try {
            int index1 = 0;
            for(BankAccount bankAccountFrom : this.bank.accounts ) {
                if (bankAccountFrom.getNrAccount() == nrAccountFrom) {
                    int index2 = 0;
                    for (BankAccount bankAccountTo : this.bank.accounts) {
                        if (bankAccountTo.getNrAccount() == nrAccountTo) {
                            this.bank.transfer(index1, index2, amount);
                        }//TO.raport(index1, amount);
                        else throw new NrAccountEx();
                        index2++;
                    }
                }
                else throw new NrAccountEx();
                index1++;
            }
        } catch (NrAccountEx e) {
            System.out.println(e.getMessage());
        }*/}

        public void save(String filename) throws IOException {
            ioBank.save(bank,filename);
        }
        public void read(String filename) throws IOException, ClassNotFoundException {
            bank=ioBank.read(filename);
    }
    }

