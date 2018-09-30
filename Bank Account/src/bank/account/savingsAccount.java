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
public class savingsAccount extends BankAccountClass {
    private int counter;
    public savingsAccount(String accountName,
            String accountNumber,
            String address,
            double balance){
        super(accountName,accountNumber,address,balance);
        counter=0;
    }
    
    public void withdraw(int amount){
        if(amount>0 && amount<=getBalance()){
           if(counter<2){
               counter++;
               super.withdraw(amount);
           }
        }
    }
    
    public void resetCounter(){
        counter=0;
    }
    
    
}
