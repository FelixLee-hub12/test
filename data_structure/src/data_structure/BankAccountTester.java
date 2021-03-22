package data_structure;

import java.io.*;

public class BankAccountTester 
{
   public static void main(String[] args)
   {
      String number, name;
      double amtIn, amtOut;
      BankAccount ac;

      // get the details from the user
      System.out.println("Bank Account Number? ");
      number = EasyIn.getString();
      System.out.println("Bank Account Holder's Name? ");
      name = EasyIn.getString();
      System.out.println("Amount to be deposited in the bank account? ");
      amtIn = EasyIn.getDouble();
      System.out.println("Amount to be withdrawn from the bank account? ");
      amtOut = EasyIn.getDouble();
      
      // create a new bank account
      // insert your code here
      ac = new BankAccount(number, name);

      
      // perform deposit and withdrawal
      // insert your code here
      ac.deposit(amtIn);
      ac.withdrawal(amtOut);

      // display the bank account's details
      // insert your code here
      

      System.out.println("Account no: " + ac.getAccountNum());
      System.out.println("Account Name: " + ac.getAccountName());
      System.out.println("Current Balance: " + ac.getBalance());
      EasyIn.pause();
   }

}