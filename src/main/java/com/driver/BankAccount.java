package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;


    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception, AccountNumberGenerationException {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        Random random=new Random();
        StringBuilder accountNumber=new StringBuilder();
        int currentsum=0;
        for(int i=0;i<digits-1;i++){
            int digit=random.nextInt(10);
             currentsum +=digit;
             accountNumber.append(digit);
        }
        int lastdigit=sum-currentsum;
        if(lastdigit <0 || lastdigit>9){
            throw new AccountNumberGenerationException("Account Number can not be generated");
        }
        accountNumber.append(lastdigit);

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;

    }

    public void withdraw(double amount) throws Exception, InsufficientBalanceException {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
      if(balance-amount<minBalance){
          throw new InsufficientBalanceException("Insufficient Balance");
      }
    }

}