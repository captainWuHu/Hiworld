import java.io.File;

public class Account {
    protected double balance;
    public Account(double init){
        this.balance = init;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double awt){
        balance+=awt;
    }
    public void withdraw(double awt) throws OverdraftException{
        if(this.balance<awt)
            throw new OverdraftException("余额不足,缺少",awt-balance);
            this.balance -= awt;
    }

    public static void main(String[] args) throws OverdraftException {
        File file = new File("C:\\Users\\BXW\\Desktop\\Tsne.txt");

    }
}
