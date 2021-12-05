package unit28thread;

//Thread執行序:官方文件java.lang.thread
//Program(程式):code
//Process(程序):running code
//Thread(執行緒):Process裡面至少會有一個Thread,預設為main,可以有多個Thread同時運行
public class Unit28Thread {

    public static void main(String[] args) {
        String name="";
        int count=0;
        //currentThread(取得目前的執行緒) 官方文件:為內部類別static方法要用Thread類別調用,回傳為object用getName轉成字串
        name=Thread.currentThread().getName();
        count=Thread.activeCount();
        System.out.println("目前的執行序名稱 : " + name);
        System.out.println("目前活動中的執行緒" + count);
        
        MyThread mt1=new MyThread();
        MyThread mt2=new MyThread();
        
        mt1.setName("鬼滅之刃");
        mt2.setName("海賊王");
        
        System.out.println("最高優先順序:" + Thread.MAX_PRIORITY); //MAX優先權10
        System.out.println("預設優先順序:" + Thread.NORM_PRIORITY); //NORM優先權5
        System.out.println("最低優先順序:" + Thread.MIN_PRIORITY); //MIN優先權1
        
        System.out.println("---PRIORITY 修改前---");
        System.out.println("mt1 : " + mt1.getPriority()); //採預設優先權5
        System.out.println("mt2 : " + mt2.getPriority()); //採預設優先權5
        //mt1.start(); //呼叫run(),啟動執行緒
        //mt2.start();
        
        System.out.println("---PRIORITY 修改後---");
        mt1.setPriority(10);
        mt2.setPriority(1);
        System.out.println("mt1 : " + mt1.getPriority()); //優先權10
        System.out.println("mt2 : " + mt2.getPriority()); //優先權1
        //mt1.run(); //Thread Name = main
        //mt2.run();
        mt1.start(); //呼叫run(),啟動執行緒
        mt2.start();
        count=Thread.activeCount();
        System.out.println("目前活動中的執行緒" + count);
        
    }
    
}

