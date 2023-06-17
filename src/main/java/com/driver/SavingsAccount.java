package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    double balance;
    public SavingsAccount(String name, double balance,double minimumBalance ,double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, minimumBalance);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }
    @Override
    public void withdraw(double amount) throws Exception, InsufficientBalanceException {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if (amount > maxWithdrawalLimit) {
            throw new InsufficientBalanceException("Maximum Withdraw Limit Exceeded");
        }
        super.withdraw(amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount

        return balance * (1 + rate * years);
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year

        return balance * Math.pow(1 + rate / times, times * years);
    }

}
