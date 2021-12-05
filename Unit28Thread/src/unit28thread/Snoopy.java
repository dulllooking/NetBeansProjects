package unit28thread;

public class Snoopy implements Runnable{
    
    @Override
    public void run(){
        
        System.out.println("Snoopy肚子餓~~~");
        System.out.println("Snoopy打開冰箱,冰箱空空~~~");
        System.out.println("Snoopy撥打2825252~~~");
        System.out.println("Snoopy訂了海鮮Pizza和可樂~~~");
        System.out.println("Snoopy上網打英雄聯盟~~~");
        
        Pizza pizza=new Pizza();
        Thread tp=new Thread(pizza);
        tp.start();
        
        try{
            tp.join(); //呼叫join()等tp跑完才會往下跑,不加會全部跑完才開始讀秒
        }catch(InterruptedException e){
            System.out.println("Snoopy等太久不想吃了~~~");
        }
        
        if(tp.isAlive()){
            System.out.println("Snoopy肚子好餓ㄚㄚㄚㄚㄚ~~~");
        }
        else
            System.out.println("~~~叮咚,叮咚,Pizza已送達~~~");
        
        System.out.println("Snoopy付了600元~~~");
        System.out.println("Snoopy大塊朵頤~~~");
        System.out.println("Snoopy吃太飽睡著了...Zzz~~~");
        
    }
}
