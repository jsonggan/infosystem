package ex1a;

public class CheckingAccount extends Account{
    CheckingAccount(int id, double balance){
        setId(id);
        setBalance(balance);
    }

    @Override
    public void withdraw(double amount){
        if (getBalance()-amount < -5000){
            System.out.println("over limit");
        }
        else{setBalance(getBalance() - amount);}
    }
}
