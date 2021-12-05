
package unit13oop;

/*
 * 程式名稱:物件導向
 * 一個檔案只能有一個public建立Game.java來新增同packaage不同class
 */
public class Unit13OOP {

    public static void main(String[] args) {
        Employee emp=new Employee(); //無參數建構子Constructor
        
        //emp.dept="資訊部"; class宣告public時才可修改但不適合這樣用
        System.out.println("---set呼叫窗口befor---");
        emp.showInfo();
        
        System.out.println("---set呼叫窗口after---");
        emp.setId("001");
        emp.setName("科及爸");
        emp.setAge(20);
        emp.setGender('F');
        emp.setDept("資訊部");
        emp.setSalary(50000);
        emp.showInfo();
        
        System.out.println("---set呼叫窗口after所有屬性一起設定---");
        emp.setInfo("002","柯林芬",18,'M',"會計部",20000);
        emp.showInfo();
        
        System.out.println("---get呼叫窗口after---");
        System.out.println("編號:" + emp.getId());
        System.out.println("部門:" + emp.getDept());
        
        System.out.println("---職稱資訊---");
        System.out.println(emp.jobInfo(2));
        
        //調用Game.java
        System.out.println("---歡迎來到~魔獸世界---");
        Game game=new Game();
        game.idInfo("amy");
        game.pwdInfo("134");
        game.serverInfo("mapple.com");
        game.playerInfo("獨孤求派");
        game.hpInfo(10);
        game.mpInfo(20);
        game.spInfo(10);
        game.login();
        
    }
}
    
//建立類別
//public class Employee{
//一個.java檔案,只能有一個public class
class Employee{

    //成員變數,屬性或特性
    private String id="000";
    private String name="未命名";
    private int age;                //初值可省略
    private char gender='M';
    private String dept;            //-private +public
    private double salary;
    private int job;

    //成員方法,行為或動作method
    public void showInfo(){
        System.out.println("---員工基本資料---");
        System.out.println("員工編號 : " + this.id);
        System.out.println("員工姓名 : " + this.name);
        System.out.println("員工年齡 : " + this.age);
        System.out.println("員工性別 : " + this.gender);
        System.out.println("員工部門 : " + this.dept);
        System.out.println("員工薪資 : " + this.salary);
    }

    //存取資訊的窗口

    //設定字,setter
    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setGender(char gender){
        this.gender=gender;
    }
    public void setDept(String dept){
        this.dept=dept;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public void setInfo(String id,String name,int age,char gender,String dept,double salary){
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.dept=dept;
        this.salary=salary;
    }

    //取得子,getter (-private to +public)
    public String getId(){return this.id;}
    public String getName(){return this.name;}
    public int getAge(){return this.age;}
    public char getGender(){return this.gender;}
    public String getDept(){return this.dept;}
    public double getSalary(){return this.salary;}

    //設定職稱
    //setter與getter
    public String jobInfo(int job){
        this.job=job;
        String str="";
        switch(this.job){
            case 1:
                str="董事長";
                break;
            case 2:
                str="總經理";
                break;
            case 3:
                str="資訊經理";
                break;
            case 4:
                str="資訊副理";
                break;
            case 5:
                str="工程師";
                break;
            case 6:
                str="助理";
                break;
            default :
                str="不知";
        }
        return ("職稱編號:"+ this.job + "\n您的職稱:" + str);
    }

}
