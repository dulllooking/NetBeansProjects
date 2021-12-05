package unit14constructor;

public class Employee {
    //成員變數,屬性
    private String id;
    private String name;
    private int age;
    private String dept;
    private double salary;
    
    private int count;
    
    //靜態類別變數,所有建構子都能使用,所以主程式呼叫不同建構子時人數會++
    private static int count2;
    
    /*
    建構子(式)
    名稱一定要與類別相同Emplyee
    無傳回值
    *若無自訂任何建構子,java才會自動產生空參數的建構子
    設定初始值
    */
    
    //空參數建構子
    public Employee(){
        this.id="0000";
        this.name="無此人";
        this.age=20;
        this.dept="未指定";
        this.salary=23000.0;
        
        count++;
        count2++;
    }
    
    //自訂有參數的建構子
    public Employee(String id,String name,int age,String dept,double salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.dept=dept;
        this.salary=salary;
        
        count++;
        count2++;
    }
    //自訂有部分參數的建構子,先判斷參數數量與型別
    //public Employee(String id,String dept)無法執行
    //public Employee(String id,int age)可以執行
    public Employee(String id,String name){
        this.id=id;
        this.name=name;
        
        count++;
        count2++;
    }
    
    //成員方法(行為)
    /*
    public void setinfo(String id,String name,int age,String dept,double salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.dept=dept;
        this.salary=salary;
    }
    */
    public void showinfo(){
        System.out.println("---員工基本資料---");
        System.out.println("員工編號:" + this.id);
        System.out.println("員工姓名:" + this.name);
        System.out.println("員工年齡:" + this.age);
        System.out.println("員工部門:" + this.dept);
        System.out.println("員工薪資:" + this.salary);
        
        System.out.println("部門人數:" + this.count);
        System.out.println("企業人數:" + count2);
        //System.out.println("企業人數:" + this.count2); //避免使用,可能有2個count2時會有問題
        //System.out.println("企業人數:" + Employee.count2); //OK
    }
    /*
    overload 多載
    方法名稱一樣
    參數長度不一樣
    參數長度一樣,但型別不一樣
    參數長度一樣,型別一樣,但位置不一樣
    不驗修飾子
    不驗傳回值
    */
    public void setinfo(String id,String name,int age,String dept,double salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.dept=dept;
        this.salary=salary;
    }
    //參數長度不一樣
    public void setinfo(String id,String name){
        this.id=id;
        this.name=name;
    }
    
    //參數長度一樣,但型別不一樣
    public void setinfo(String id,int age){
        this.id=id;
        this.age=age;
    }
    
    //參數長度一樣,型別一樣,但位置不一樣
    public void setinfo(String id,int age,double salary){
        this.id=id;
        this.age=age;
        this.salary=salary;
    }
    public void setinfo(String id,double salary,int age){
        this.id=id;
        this.salary=salary;
        this.age=age;
    }
    
    //不驗修飾子('+'public(公開),'-'private(隱私),'#'protected(保護),''default(不寫任何修飾))
    public void setinfo(String id){
        this.id=id;
    }
    //只能用public,private,protected,default其中一個修式子
    /*
    public protected setinfo(String id){
        this.id=id;
    }
    */
    
    //不驗傳回值
    /*
    public String setInfo(String id){
        this.id=id;
        return this.id;
    }
    */
}
