package unit16extends;

public class Tank {
    private String id;
    private int hp;
    //與class同名所以是constructor建構子(有連結)
    public Tank(){
        System.out.println("我是一輛坦克");
        this.hp=100;
    }
    public Tank(String id){
        System.out.println("我是一輛坦克");
        this.id=id;
        this.hp=1000;
    }
    //與class不同名所以show是method方法
    public void show(){
        System.out.println("我是一輛坦克");
        System.out.println("坦克編號:" + this.id);
        System.out.println("坦克生命值:" + this.hp);
    }
    //fire(class Tank型別 target變數)
    public void fire(Tank target){
        System.out.println("坦克" + this.id + "向坦克" + target.id + "發射了砲彈!!>.<");
    }
}//Tank end
    
class HeavyTank extends Tank {
    private boolean gun;
        
    public HeavyTank(boolean gun){
        System.out.println("我是重坦克");
        this.gun=gun;
    }
    public HeavyTank(boolean gun, String id){
        super(id); //調用上類別有參數建構子public Tank(String id)
        System.out.println("我是重坦克");
        this.gun=gun;
    }
    public void show(){
        System.out.println("是否有配槍" + this.gun);
        super.show(); //調用上類別的方法public void show()
    }
    public void rake(){
        if(this.gun)
            System.out.println("我配有機槍可以掃射");
        else
            System.out.println("我沒有機槍");
    }
}        
    
class AmphiTank extends Tank{
        
    public AmphiTank(String id){
        super(id);
        System.out.println("我是兩棲坦克");
    }
    public void show(){
        System.out.println("兩棲坦克資訊:");
        super.show();
    }
    public void swim(){
        System.out.println("我可以水上漂");
    }
}//AmphiTank end
    
class BoomTank extends Tank{
        
    public BoomTank(String id){
        super(id);
        System.out.println("我是炸彈坦克");
    }
    public void show(){
        System.out.println("炸彈坦克資訊:");
        super.show();
    }
    public void blowUp(){
        System.out.println("我要爆炸了!!!");    
    }
}//BoomTank end
