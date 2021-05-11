package View;

import Controller.BusinessLogic;
import Controller.IOBank;
import Model.Bank;
import Model.BankAccount;
import Model.Owner;
import Model.SavingAccount;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;

public class GraphicalInterface extends JFrame{
    private JTextField TFname;
    private JTextField TFsurname;
    private JButton ADDButton;
    private JTextField TFwdaccnum;
    private JTextField TFwdamount;
    private JButton WITHDRAWButton;
    private JButton DEPOSITButton;
    private JTextField TFtfromaccnum;
    private JTextField TFttoaccnum;
    private JTextField TFtamount;
    private JButton TRANSFERButton;
    private JTextField TFfilenamesave;
    private JButton SAVEButton;
    private JButton READButton;
    private JTextField TFfilenameread;
    private JTextArea textArea1;
    private JPanel mainPanel;
    private JTextField TFinterest;
    private JButton BALANCEButton;
    Bank bank = new Bank();
    BusinessLogic businessLogic = new BusinessLogic(bank);
    IOBank ioBank = new IOBank();

    public GraphicalInterface() {
        this.setSize(800,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        ADDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Owner owner = new Owner();
                owner.setName(TFname.getText());
                owner.setSurname(TFsurname.getText());
                if (TFinterest.getText().equals("")){
                BankAccount num=businessLogic.addNewAccount(owner);
                textArea1.setText("Dodano nowe zwykłe konto użytkownika "+owner.getName()+" "+owner.getSurname()+" o numerze: "+num.getNrAccount());}
                else {
                    double interest =Double.parseDouble(TFinterest.getText());
                    SavingAccount num1= businessLogic.addNewAccount(owner,interest);
                textArea1.setText("Dodano nowe konto oszczędnościowe użytkownika "+owner.getName()+" "+owner.getSurname()+" o numerze: "+num1.getNrAccount()+" i oprocentowaniu "+num1.getInterest()+".");
                }
                TFinterest.setText("");
                TFname.setText("");
                TFsurname.setText("");
            }
        })
        ;
        WITHDRAWButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                double WAmount=Double.parseDouble(TFwdamount.getText());
                int WAccNum=Integer.parseInt(TFwdaccnum.getText());
                businessLogic.withdraw(WAccNum,WAmount);
                textArea1.setText("Z konta o numerze "+WAccNum+" zostało wypłacone "+WAmount+" zł.");
                } catch(Exception exception) {
                    textArea1.setText("Wystąpił błąd: "+exception.getMessage());;}
                TFwdamount.setText("");
                TFwdaccnum.setText("");
            }
        });
        DEPOSITButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                double DAmount = Double.parseDouble(TFwdamount.getText());
                int DAccNum = Integer.parseInt(TFwdaccnum.getText());
                businessLogic.deposit(DAccNum, DAmount);
                textArea1.setText("Na konto o numerze "+DAccNum+" zostało wpłacone "+DAmount+" zł.");
                } catch(Exception exception) {
                    textArea1.setText("Wystąpił błąd: "+exception.getMessage());} //coś z catchami
                TFwdamount.setText("");
                TFwdaccnum.setText("");
            }
        });
        TRANSFERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double TAmount = Double.parseDouble(TFtamount.getText());
                    int TFromAccNum = Integer.parseInt(TFtfromaccnum.getText());
                    int TToAccNum = Integer.parseInt(TFttoaccnum.getText());
                    businessLogic.transfer(TFromAccNum, TToAccNum, TAmount);
                    textArea1.setText("Z konta o numerze "+TFromAccNum+" na konto o numerze "+TToAccNum+ " zostało przesłane "+TAmount+" zł.");
                } catch(Exception exception) {
                    textArea1.setText("Wystąpił błąd: "+exception.getMessage());} //coś z catchami
                TFtamount.setText("");
                TFtfromaccnum.setText("");
                TFttoaccnum.setText("");
            }
        });

        SAVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    businessLogic.save(TFfilenamesave.getText());
                    textArea1.setText("Dane zapisane.");
                    TFfilenamesave.setText("");
                }
                catch(Exception ex) {
                    textArea1.setText("Wystąpił błąd: "+ex.getMessage());
                }
            }
        });

        READButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    businessLogic.read(TFfilenameread.getText());
                    TFfilenamesave.setText("");
                    textArea1.setText("Dane wczytane. ");
                }
                catch(Exception ex) {
                    textArea1.setText("Wystąpił błąd: "+ex.getMessage());
                }
                TFfilenameread.setText("");
            }
        });
    }
}
