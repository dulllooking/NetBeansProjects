package unit27string;
import java.text.DecimalFormat;

public class Menu {
    
    private double total=0;
    
    //取得訂單總額
    //public double getTotal(String[] menu){ //主程式可呼叫會重複計算
    private double getTotal(String[] menu){
        
        for(String e:menu){
            int price=Integer.parseInt(e.substring(e.indexOf(",")+1, e.length()-1));
            this.total += price;
        }
        return this.total;
    }
    
    public void getMenuInfo(String[] menu){
        
        System.out.println("~~~您訂的餐點明細如下 : ~~~");
        for(int i=0; i<menu.length; i++){
            System.out.println("第" + (i+1) + "項 :" + menu[i]);
        }
        this.total=this.getTotal(menu);
        DecimalFormat df=new DecimalFormat("#,##0.00");
        System.out.println("小計 : " + df.format(this.total) + "元");
        System.out.println("小費 : " + df.format(this.total*0.1) + "元");
        System.out.println("總額 : " + df.format(this.total*1.1) + "元");
    }
}
