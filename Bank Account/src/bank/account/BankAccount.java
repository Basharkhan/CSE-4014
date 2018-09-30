/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account;

import java.io.PrintStream;

/**
 *
 * @author USER-PC
 */
public class BankAccount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //declration
        BankAccountClass accountObject;
        //instantiation
        /*
        accountObject=new BankAccountClass();
        accountObject.accountName="Pappi";
        accountObject.balance=100;
        accountObject.deposit(200);
        accountObject.withdraw(300);
        */
        BankAccountClass anotherAccount;
        savingsAccount myAccount;
        
       // anotherAccount=new BankAccountClass("Noyon Bl","420","kaji-para",1000);
        myAccount=new savingsAccount("Bashar khan","020","Rajbari",9999);
        anotherAccount=new BankAccountClass("Mamun","120","Kakiladair",2000999);
       
       anotherAccount.deposit(2000);
       
       anotherAccount.withdraw(1);
       anotherAccount.withdraw(1);
       anotherAccount.withdraw(1);
       
         myAccount.withdraw(1);
         myAccount.withdraw(1);
         myAccount.withdraw(100);
      // anotherAccount.balance=10005;
       
       
       /*
      // anotherAccount.setAddress(Mirpur);
     
       // anotherAccount=new BankAccountClass();
      //  anotherAccount.accountName="Noyon Bl";
       
       // anotherAccount.address="kajipara";
      //  anotherAccount.setAddress(mirpur);
       // anotherAccount.balance=1;
       // anotherAccount.balance=100000;
        */

       // System.out.printf("%s\n%s\n%.2f\n",anotherAccount.getAccountName(),anotherAccount.getAddress(), anotherAccount.getBalance());
        
      //  System.out.printf("Name: %s\nAddress:%s\nBalance: %.2f\n",myAccount.getAccountName(),myAccount.getAddress(), myAccount.getBalance());
       System.out.println(myAccount.getAccountName() +" "+ myAccount.getAddress() +" "+ myAccount.getBalance());
       System.out.println(anotherAccount.getAccountName() +" "+anotherAccount.getAddress() +" "+ anotherAccount.getBalance());
    }
    
}
