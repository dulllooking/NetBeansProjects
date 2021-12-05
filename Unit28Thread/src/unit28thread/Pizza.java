package unit28thread;

public class Pizza implements Runnable{
    
    @Override
    public void run(){
    
        System.out.println("~~~外送員騎著Gogoro, Pizza 正在送來的途中~~~");
        System.out.println(".......");
        
        for(int i=1; i<=10; i++){
            try{
                Thread.sleep(1000); //請執行緒睡著1秒,sleep可能被中斷需包InterruptedException使用
            }catch(InterruptedException e){
                System.out.println("~~~Gogoro,沒電GG了~~~");
            }
            System.out.println("第" + i + "分");
        }
        //System.out.println("~~~叮咚,叮咚,Pizza已送達~~~");
    }
}
