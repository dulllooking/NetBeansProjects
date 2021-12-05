
package unit15extends;

//上類別,父類別super class(parent)
public class Animal {
    private int leg=0;
    public static int count=0;
    
    public Animal(){
        count++;
        System.out.println("我是一隻動物");
    }
    public void move(){
        System.out.println("我會動來動去");
    }
    public int getLeg(){
        return this.leg;
    }
} //Animal end

//子類別,衍生類別,sub class(child),derived class
//使用extends 表示Dog繼承Animal
class Dog extends Animal{
    public static int count=0;

    public Dog(){
        super(); //呼叫上類別的建構子,會自動呼叫,可省略(要加只能放在第一行):呼叫 public Animal()
        count++;
        System.out.println("我是一隻小狗");    
    }
} //Dog end

class Lion extends Animal{
    public static int count=0;

    public Lion(){
        count++;
        System.out.println("我是一隻獅子");    
    }
} //Lion end

class Fish extends Animal{
    public static int count=0;

    public Fish(){
        count++;
        System.out.println("我是一隻魚");    
    }
    public void move(){
        System.out.print("我會游來游去");
    }
} //Fish end

class Bird extends Animal{
    public static int count=0;

    public Bird(){
        count++;
        System.out.println("我是一隻鳥");    
    }
    public void move(){
        System.out.println("我會飛來飛去");
    }
} //Bird end

class Ostrich extends Bird{
    public static int count=0;

    public Ostrich(){
        count++;
        System.out.println("我是一隻鴕鳥");    
    }
    public void move(){
        System.out.println("我會跑來跑去");
    }
    public void skill(){
        System.out.println("我跑步超快");
    }
} //Ostrich end