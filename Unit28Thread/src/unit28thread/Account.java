package unit28thread;

public class Account {
    
    private int balance; //記錄餘額
    
    public Account(int balance){ //建構子
        this.balance=balance;
    }
    
    //synchronized同步化的方法,當物件被存取時,必須等到Lock解開,才可以存取
    /*synchronized需指定一個物件,系統會Lock此物件
     *當程式進入synchronized區塊或Method時,該物件會被Lock,直到離開synchronized才會釋放
     *Lock期間,鎖定同一物件的其他synchronized區塊會因為無法取得物件的Lock而等待
     *待物件Release Lock後,其他的synchronized區塊會有一個取得該物件的Lock而可以執行
     */
    public synchronized void inOut(int money){
        int balance=this.balance; //交易前,先暫時將目前的餘額指定給balance
        System.out.println("您目前的餘額 : " + balance + "元");
        
        if(money >= 0)
            System.out.println("您的存款金額 : " + money + "元");
        else 
            System.out.println("您的提款金額 : " + -(money) + "元"); //顯示時為負負得正
        
        System.out.println("交易中...請勿離開!");
        try{
            for(int i=1; i<=5; i++){
                Thread.sleep(1000);
                System.out.print(".");
            }
            System.out.println();
        }catch(InterruptedException e){
            System.out.println("目前疑似盜領中,機器暫停,等待警方到來~~~");
        }
        balance += money;
        if(balance >= 0){
            this.balance=balance;
            System.out.println("本次交易後,您目前的餘額 : " + this.balance);
        }else
            System.out.println("~~~您的存款不足~~~");
        System.out.println("=====================================\n");
    }
}
