package unit16extends;

public class Weapon {

    public static void main(String[] args) {
        Tank tank1=new Tank("0001");
        Tank tank2=new Tank("0002");
        System.out.println("------------------------------------");
        
        tank1.show();
        System.out.println("------------------------------------");
        
        tank2.show();
        System.out.println("------------------------------------");
        
        tank1.fire(tank2);
        System.out.println("------------------------------------");
        
        HeavyTank htank=new HeavyTank(true,"0003");
        System.out.println("------------------------------------");
        
        htank.show();
        System.out.println("------------------------------------");
        
        htank.rake();
        System.out.println("------------------------------------");
        
        AmphiTank atank=new AmphiTank("A0001");
        BoomTank btank=new BoomTank("B0001");
        System.out.println("------------------------------------");
        
        btank.fire(atank);  //調用上類別方法
        System.out.println("------------------------------------");
        
        btank.show();
        btank.blowUp();
    }
    
}
