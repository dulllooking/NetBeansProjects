package unit19interface;
/*
* 介面 Interface
*/

public class Tank {
    private String id;
    private int hp;
    
    public void show(){
        
    }
} //Tank end

class HeavyTank{}
class AmiphTank{}
class BoomTank{}

//java 只能單一繼承,不能多重繼承
//class SuperTank extends Tank,HeavyTank,AmiphTank,BoomTank{


//interface,介面使用 interface 關鍵字,此寫法較多餘,可同ISwin,IBoom寫法
interface IRake {
    
    public static final String WITH="機槍"; //WITH常數
    
    //public IRake(){} //interface 無建構子
    
    //interface 的方法為抽象方法,不可有body{...}
    public void rake();
} //IRake end


interface ISwin{
String WITH="防水履帶"; //interface 所有屬性都是public,static,final,所以可省略
public void swim(); //抽象方法
}

interface IBoom{
String WITH="炸彈"; //interface 所有屬性都是public,static,final,所以可省略
public void blowUp(); //抽象方法
}

//繼承Tank,實作 IRake,ISwin,IBoom 後才不會出現錯誤
//implements實現介面接口對接多個介面
class SuperTank extends Tank implements IRake,ISwin,IBoom{
    public void rake(){
        System.out.println("我擁有重型機槍我是重型坦克:" + IRake.WITH);
    }
    public void swim(){
        System.out.println("我擁有防水履帶我是兩棲坦克:" + ISwin.WITH);
    }
    public void blowUp(){
        System.out.println("我擁有彈射炸彈我是炸彈坦克:" + IBoom.WITH);
    }
}
