package unit18abstract;
import java.util.Calendar;
/*
 * 程式名稱
*/
public class Unit18Abstract {

    public static void main(String[] args) {
        //Calendar cd=new Calendar(); //錯誤:Calendar是抽象類別無法實體
        //查文件時找subclass子類別的method()有填型別的表示實作,可使用
        //Tank tank1=new Tank(); //錯誤:抽象類別無法實體
        //FeatherTank ftank1=new FeatherTank(); //錯誤:抽象類別無法實體
        
        //抽象類別的subclass子類別可以實體
        AmphiTank at=new AmphiTank();
        HeavyTank ht=new HeavyTank();
        
        at.move(); //調用自己覆寫上類別的方法
        at.show(); //調用自己實作上類別的方法
        
        System.out.println("------------------------");
        
        ht.move(); //調用上類別的方法
        ht.show(); //調用自己實作上類別的方法
        
    }
    
}
