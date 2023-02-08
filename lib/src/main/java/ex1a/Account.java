package ex1a;

import java.util.Date;

public class Account {
    private int id=0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated = new Date();

    //no arg constructor and will call the complete constructor
    Account(){
        this(0,0.0);
    }
    Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public static void setAnnualInterestRate(double annualInterestRate){
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return getAnnualInterestRate()/12.0;
    }

    public double getMonthlyInterest(){
        return getBalance() * (getMonthlyInterestRate()/100.0);
    }

    public void withdraw(double amount){
        setBalance(getBalance() - amount);
    }
    public void deposit(double amount){
        setBalance(getBalance() + amount);
    }
}


