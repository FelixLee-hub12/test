package data_structure;

class SavingAccountTester 
{
   public static void main(String[] args)
   {
      String number, name;
      double interestRate, amtIn, amtOut;
      SavingAccount savings_ac;

      // get the details from the user
      System.out.println("Savings Account Number? ");
      number = EasyIn.getString();
      System.out.println("Savings Account Holder's Name? ");
      name = EasyIn.getString();
      System.out.println("Interest Rate for the Savings Account? ");
      interestRate = EasyIn.getDouble();
      System.out.println("Amount to be deposited in the savings account? ");
      amtIn = EasyIn.getDouble();
      System.out.println("Amount to be withdrawn from the savings account? ");
      amtOut = EasyIn.getDouble();
      
      // Insert your code here
      savings_ac = new SavingAccount(number,name,interestRate);
      savings_ac.deposit(amtIn);
      savings_ac.withdrawal(amtOut);
      
      System.out.println("Saving Account No: " + savings_ac.getAccountNum());
      System.out.println("Saving Account Name: " + savings_ac.getAccountName());
      System.out.println("Current: " + savings_ac.getBalance());
      System.out.println("Interest Rate: " + savings_ac.getInterestRate());
      System.out.println("Interest: " + savings_ac.calculateInterest());

      System.out.println("New interest Rate for the Savings Account? ");
      interestRate = EasyIn.getDouble();
      
      // Insert your code here	
      savings_ac.setInterestRate(interestRate);
      System.out.println("New interest Rate: "+ savings_ac.getInterestRate() );
      System.out.println("New interest: "+ savings_ac.calculateInterest());



      EasyIn.pause();
   }

}