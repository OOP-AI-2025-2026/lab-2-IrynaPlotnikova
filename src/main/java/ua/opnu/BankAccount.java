package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0;

    public BankAccount() {
        this.name = "Bob";
        this.balance = 0.00;
        this.transactionFee = 0;
    }

    public BankAccount(String ownerName, double startingBalance) {
        this.name = ownerName;
        this.balance = startingBalance;
        //this.transactionFee = 0;
    }

    void deposit(double amount) {
        if (amount > 0){
            balance += amount;
        }
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        double totalToWithdraw = amount + this.transactionFee;
        if (amount > 0 && this.balance >= totalToWithdraw) {
            this.balance -= totalToWithdraw;
            return true;
        }
        return false;
    }

    boolean transfer(BankAccount receiver, double amount) {
        double totalCost = amount + this.transactionFee;
        if (amount > 0 && totalCost <= this.balance){
            this.balance -= totalCost;
            receiver.deposit(amount);
            return true;
        }
        return false;
    }
}