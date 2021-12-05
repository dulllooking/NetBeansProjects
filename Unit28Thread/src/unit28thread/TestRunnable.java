package unit28thread;

//測試實作Runnable 類別
public class TestRunnable {
    
    public static void main(String[] args) {
        
        MyRunnable mr1=new MyRunnable();
        MyRunnable mr2=new MyRunnable();
        
        //mt1.start(); //MyRunnable繼承的Rannable只有run()方法
        //mt2.start();
        
        Thread t1=new Thread(mr1, "七龍珠");
        Thread t2=new Thread(mr2, "烏龍派出所");
        
        t1.start();
        t2.start();
    }
}
