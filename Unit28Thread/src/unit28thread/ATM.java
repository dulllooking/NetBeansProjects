package unit28thread;

public class ATM extends Thread{
    
    private Account account;
    private int money;
    
    public ATM(Account account, int money){
        this.account=account;
        this.money=money;
    }
    
    //覆寫上類別的run()
    @Override
    public void run(){
        this.account.inOut(this.money); //呼叫Account 類別的方法
    }
}
