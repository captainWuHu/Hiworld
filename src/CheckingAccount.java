public class CheckingAccount extends Account{
    private double overdraftProtection;
    public CheckingAccount(double init) {
        super(init);
        overdraftProtection = 0;
    }
    public CheckingAccount(double init, double protect){
        this(init);
        overdraftProtection = protect;
    }


    @Override
    public void withdraw(double awt) throws OverdraftException {
        if(balance+overdraftProtection<awt)
            throw new OverdraftException("余额不足，已透支上限",awt - balance-overdraftProtection);
        if(balance<awt)overdraftProtection-=awt;
        else balance-=awt;
    }
}
