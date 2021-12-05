package unit21map;

public class Employee{
        
    //成員變數,屬性或特性
    private String id="000";
    private String name="未命名";
    private int age;                //初值可省略
    private char gender='M';
    private String dept;            //-private +public
    private double salary;
    private int job;
    
    //HashSet指定資料用
    public Employee(String id,String name){
        this.id=id;
        this.name=name;
    }
        
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
    
    //Iterator輸出時用
    public String getIdName(){
        return this.id + "," + this.name;
    }

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