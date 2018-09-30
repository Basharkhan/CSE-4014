/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account;

/**
 *
 * @author USER-PC
 */
public class BankAccountClass {
    
      private String accountName;
      private String accountNumber;
      private String address;
      private double balance;

    
    public BankAccountClass(String nAccountName,String nAccountNumber,String nAddress,double nBalance){
        accountName=nAccountName;
        accountNumber=nAccountNumber;
        address= nAddress;
        balance= nBalance;
    }
    
    public void deposit(int amount){
        if(amount>0)
            balance=balance+amount;
    }
    
   public void withdraw(int amount){
        if(amount>0 && amount <=balance)
            balance=balance-amount;
    }
   public double getBalance(){
        return balance;
    }
   
   public String getAccountName(){
       return accountName;
   }
   
   public String getAddress(){
       return address;
   }
   
   public void setAddress(String newAddress){
       address=newAddress;
   }
   
    
}
