/*
 * 程式名稱:constructor建構子(式)的宣告與使用
 */
package unit14constructor;

public class Unit14Constructor {

    
    public static void main(String[] args) {
        //呼叫空參數建構子
        Employee emp=new Employee(); //使用空參數建構子,建立實體物件,emp 變數
        emp.showinfo();
        
        //呼叫有參數的建構子,有參數的建構子會先判斷參數數量再參考型別去呼叫建構子
        Employee emp2=new Employee("0001","愛台完");
        emp2.showinfo();
        
        Employee emp3=new Employee("0002","真友前",30,"財務部",2500.3);
        emp3.showinfo();
        
        emp3.setinfo("0003",20,2030.5);
        emp3.showinfo();
        
        System.out.println("---參考物件在記憶體的配置---");
        Shirt myshirt=new Shirt();
        Shirt yourshirt=new Shirt();
        
        System.out.println("--- 在java.lang中的String 類別---");
        String str="Hello";
        String str2=new String(); //String()空參數建構子
        char[] greeting={'H','e','l','l','o'};
        String str3=new String(greeting); //String(char[] value)有一個參數的建構子
        System.out.println(str3);
        
    }
    
}
