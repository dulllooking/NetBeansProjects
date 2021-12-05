package unit19abstract;

//抽象類別
abstract class Shape {
    //protected只有繼承關係的成員可以使用
    protected String name;
    protected int length; //記錄矩形的長
    protected int width; //記錄矩形的寬
    protected double height; //記錄三角形的高
    protected double bottom; //記錄三角形的底
    protected double radius; //記錄圓形的半徑
    
    //用於矩形建構子
    public Shape(String name, int length, int width){
        this.name=name;
        this.length=length;
        this.width=width;
    }
    
    //用於三角形建構子
    public Shape(String name, double height, double bottom){
        this.name=name;
        this.height=height;
        this.bottom=bottom;
    }
    
    //用於圓形建構子
    public Shape(String name, double radius){
        this.name=name;
        this.radius=radius;
    }
    
    //抽象方法,子類別一定要實作
    abstract double area();
    abstract double perimeter();
    
    //一般方法
    public void show(){
        System.out.println("形狀名稱:" +this.name);
        System.out.println("形狀長:" +this.length);
        System.out.println("形狀寬:"+this.width);
        System.out.println("形狀高:"+this.height);
        System.out.println("形狀底:"+this.bottom);
        System.out.println("形狀半徑:"+this.radius);
    }
} //Shape end


class Rectangle extends Shape{
    
    public Rectangle(String name, int length, int width){
        super(name,length,width);
    }
    
    //實作上類別的抽象方法,面積 
    public double area(){
        return super.length*super.width; //有做自動轉型
    }
    
    //實作上類別的抽象方法,周長
    public double perimeter(){
        return (super.length+super.width)*2; //有做自動轉型
    }
    
    //覆寫
    @Override
    public void show(){
        System.out.println("形狀名稱:" +this.name);
        System.out.println("形狀長:" +this.length);
        System.out.println("形狀寬:"+this.width);
        System.out.println("面積:"+this.area());
        System.out.println("周長:"+this.perimeter());
    }
} //Retangle end


class Triangle extends Shape{
    //以正三角形為例
    public Triangle(String name, double height, double bottom){
        super(name,height,bottom);
    }
    
    //實作上類別的抽象方法,面積 
    public double area(){
        return (super.bottom*super.height)/2;
    }
    
    //實作上類別的抽象方法,周長
    public double perimeter(){
        return super.bottom*3;
    }
    
    //覆寫
    @Override
    public void show(){
        System.out.println("形狀名稱:" +this.name);
        System.out.println("形狀高:"+this.height);
        System.out.println("形狀底:"+this.bottom);
        System.out.println("面積:"+this.area());
        System.out.println("周長:"+this.perimeter());
    }
} //Triangle end


class Circular extends Shape{
    
    final double PI=3.14159; //將PI 設為常數
    
    public Circular(String name, double radius){
        super(name,radius);
    }
    
    public double area(){
        return super.radius*super.radius*PI;
    }
    
    //實作上類別的抽象方法,周長
    public double perimeter(){
        return super.radius*PI*2;
    }
    
    //覆寫
    @Override
    public void show(){
        System.out.println("形狀名稱:" +this.name);
        System.out.println("形狀半徑:"+this.radius);
        System.out.println("面積:"+this.area());
        System.out.println("周長:"+this.perimeter());
    }
}


