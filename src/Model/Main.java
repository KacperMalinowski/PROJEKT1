package Model;

import Model.Offices.TaxOffice;
import View.GraphicalInterface;

public class Main {

    public static void main(String[] args) {
        //ArrayList lista = new ArrayList();

        /*Owner owner1 = new Owner("Kacper", "Poziomkowski");
        Owner owner2 = new Owner("Repcak", "Pozioma");
        BankAccount account1 = new BankAccount(owner1,3000);
        BankAccount account2 = new BankAccount(owner2,4000);
        System.out.println("Konto właściciela "+account1.getOwner().getName()+" "+account1.getOwner().getSurname()+" ma balans: "+account1.getBalance());*/
        //TaxOffice to1=new TaxOffice(); //referencja do obiektu TaxOffice, wewnątrz którego jest ObserverOffice z metodą
        //TaxOffice to2=new TaxOffice();
        //TaxOffice to2=new TaxOffice(); //tak samo, obiekt, który ma ObserverOffice w środku
        Bank bank=new Bank();//referencja do obiektu klasy bank, wewnątrz lista observerOffice
        //bank.addObserverOffice(to1); //wywołanie metody; powstaje miejsce na liście, które jest referencją do
        //bank.addObserverOffice(to2); //...ObserverOffice; kolejne miejsce na liście
        //bank.deleteObserverOffice(to1);//usuwam ObserverOffice;
        //to1.raport();
        /*BusinessLogic businessLogic=new BusinessLogic(bank);
        businessLogic.addNewAccount(owner1);
        IOBank ioBank = new IOBank();
        ioBank.save(bank,"Zapis.ser");
        ioBank.read("Zapis.ser");
       // GraphicalInterface graphicalInterface=new GraphicalInterface();
         */
       // JFrame frame = new JFrame("Okienko");
        //frame.setContentPane(new View().getMainPanel());
        //Bank bank = new Bank();
        GraphicalInterface inter = new GraphicalInterface();

    }
}
