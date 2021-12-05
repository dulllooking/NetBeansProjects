package unit18abstract;

/**
 * Abstract Class
 */

//抽象類別,使用abstract 關鍵字
//public Abstract class Tank { //ok
abstract public class Tank { //ok
    
    //抽象類別可以有一般的成員變數
    private String id;
    private int hp;
    
    //建構子(抽象類別可以有建構子)
    public Tank(){
        System.out.println("我是坦克");
    }
    
    //抽象類別可以有一班的成員方法
    public void move(){
        System.out.println("我是坦克,可以到處行走");
    }
    
    //抽象方法不可以有body{...}
    //public Abstract void show(){} //error
    public abstract void show(); //abstract method,抽象方法
} //Tank end

//繼承Abstract clacc,要實作上類別的所有抽象方法(AmphiTank要在下方打出public void show()錯誤才會消失)
class AmphiTank extends Tank{
    
    //實作上類別的抽象方法
    public void show(){
        System.out.println("可以兩棲作戰,水裡來去自如");
    }
    
    //覆寫上類別的方法
    public void move(){
        System.out.println("我是兩棲坦克,有履帶在陸地上走,有氣墊在水裡游");
    }
} //AmphiTank end

class HeavyTank extends Tank{
    
    //實作上類別的抽象方法
    public void show(){
        System.out.println("可以兩棲作戰,水裡來去自如");
    }
    
    //覆寫上類別的方法
    public void move(){
        System.out.println("有超強的武器,可以連續射擊砲彈");
    }
} //HeavyTank end

//抽象類別繼承抽象類別,不需實作上類別方法
abstract class FeatherTank extends Tank{}
//FeatherTank end

