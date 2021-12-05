package unit28thread;

public class MyThread extends Thread{
    
    //覆寫上類別的run(),上類別Thread實作Runable介面
    @Override
    public void run(){
        
        for(int i=0; i<5; i++){
            String name=Thread.currentThread().getName();
            System.out.println(i + " Thread Name = " + name);
        }
    }
}
