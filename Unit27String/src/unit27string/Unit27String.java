package unit27string;

public class Unit27String {
/*
 *Wrapper Class 包覆類別
 *String 字串
 */    
    public static void main(String[] args) {
        //由字串所串接
        char[] java={'j','a','v','a'}; //字元陣列
        String javaStr=new String(java);
        System.out.println(javaStr);
        
        String song="love us keep alive ~eagles~";
        int songPos=song.indexOf("~"); //"~"的所在位置
        System.out.println("song 的長度" + song.length());
        System.out.println("~ 在第" + songPos + "個字");
        System.out.println("演唱樂團 : " + song.substring(songPos));
        
        String us=new String("123.123");
        //System.out.println(us*1.1); //error型別錯誤(字串無法計算)
        //由基本型別Double 包覆為一個類別
        Double usMoney=Double.parseDouble(us); //Wrapper class, 調用parseDouble()將字串轉為浮點數
        System.out.println("usMoney*1.1 為" + usMoney*1.1); //已轉為浮點數,故可進行數值運算
        
        //輸出菜單
        String[] menu={"台式海鮮總匯,200元","義大利炒麵,180元","法式烤螺肉,250元","美式豬腳焗海鮮,280元"};
        orderMenu(menu);
        
        System.out.println("\n~~~建立訂單明細物件~~~");
        Menu myMenu = new Menu();
        myMenu.getMenuInfo(menu);
        
        //String內容是不可變動的(變動會改變記憶體位置)
        System.out.println("---About String---");
        String slogan="java";
        String slogan2=new String("java"); //同String slogan2="java";
        char[] java2={'j','a','v','a'}; //字元陣列
        String slogan3=new String(java2);
        //字串會放到常數池constant pool 如果字串相同hashCode會相同
        System.out.println(slogan.hashCode()); //與下一個相同
        System.out.println(slogan2.hashCode()); //與上一個相同
        System.out.println(slogan3.hashCode()); //與上面一個相同
        if(slogan.equalsIgnoreCase(slogan2))
            System.out.println("y"); //y
        else
            System.out.println("n");
        
        slogan += "love";
        System.out.println(slogan.hashCode()); //與原來的slogan之hashCode不同,slogan2不同
        if(slogan.equalsIgnoreCase(slogan2))
            System.out.println("y");
        else
            System.out.println("n"); //n
        
        //StringBuffer,內容是可變的(同記憶體位置)
        StringBuffer sb=new StringBuffer("java");
        StringBuffer sb2=new StringBuffer("java");
        System.out.println("sb:" + sb.hashCode()); //與下不一樣
        System.out.println("sb2" + sb2.hashCode()); //與上不一樣
        
        sb.append("love");
        System.out.println("sb:" + sb.hashCode()); //與原來sb相同
    }
    
    public static void orderMenu(String[] menu){
        
        String str=""; //記錄菜單名與價錢(陣列元素值)
        int subTotal=0; //記錄價錢總計
        int price=0; //記錄每項菜單的價格
        double fee=0.0; //記錄小費
        double total=0.0; //記錄消費總額
        
        System.out.println("~~~您定的餐點如下:~~~");
        for(int i=0; i<menu.length; i++){
            str=menu[i];
            System.out.println(str);
            
            int p=str.indexOf(","); //記錄逗號的位置
            int len=str.length(); //記錄str 的長度
            String priceStr=str.substring(p+1, len-1);
            price=Integer.parseInt(priceStr); //Wrapper class
            subTotal += price;
        }
        
        fee=subTotal*0.1;
        total=subTotal+fee;
        
        System.out.println("-------------------------");
        System.out.println("小計 : " + subTotal + "元");
        System.out.println("小費 : " + fee + "元");
        System.out.println("-------------------------");
        System.out.println("總額 : " + total + "元");
    }
}
