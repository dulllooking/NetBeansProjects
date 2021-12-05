package unit28thread;

public class MyRunnable implements Runnable{
    
    //要實作上類別Runnable(介面)的 run()
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(i + "--->" + Thread.currentThread().getName());
        }
    }
}
