package Controller;

import Model.Bank;

import java.io.*;

public class IOBank {
    //public BusinessLogic businessLogic;
    public void save (Bank bank, String fileName) throws IOException
    {
        FileOutputStream zapisNaDysk;
    ObjectOutputStream zapisObiektow;
        try {
            zapisNaDysk = new FileOutputStream(fileName);
            zapisObiektow = new ObjectOutputStream(zapisNaDysk);
            zapisObiektow.writeObject(bank);
            zapisNaDysk.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public Bank read (String fileName) throws IOException
    {
        FileInputStream odcztZDysku;
        ObjectInputStream odczytObiektow;
        try {
            odcztZDysku=new FileInputStream(fileName);
            odczytObiektow=new ObjectInputStream(odcztZDysku);
            //bank=(Bank)odczytObiektow.readObject();
            return (Bank) odczytObiektow.readObject();
            //odczytObiektow.close();
            //odcztZDysku.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
