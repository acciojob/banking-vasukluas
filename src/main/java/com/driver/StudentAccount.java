package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance,double minimumBalance, String  institutionName) {
        //minimum balance is 0 by default
        super(name, balance, minimumBalance);
        this.institutionName = institutionName;
    }

}
