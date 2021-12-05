/*
多型Polymorphism,覆寫Override
*/
package unit17polymorphismoverride;

public class Unit17PolymorphismOverride {

    public static void main(String[] args) {
        
        System.out.println("---覆寫Override 說明---");
        Animal animal=new Animal();
        Dog dog=new Dog();
        Fish fish=new Fish();
        animal.move(); //調用自己的move()
        dog.move(); //調用上類別的move()
        fish.move(); //調用自己的move() 覆寫
        
        System.out.println("---多型Polymorphism 說明---");
        boolean isTrue=false;
        
        Ostrich ostrich=new Ostrich();
        ostrich.move();
        ostrich.skill();
        
        isTrue=ostrich instanceof Ostrich; //instanceof用來比較型別是否符合
        System.out.println("ostrich 是鴕鳥(Ostrich)嗎?" + isTrue); //true
        
        isTrue=ostrich instanceof Bird;
        System.out.println("ostrich 是鳥(Bird)嗎?" + isTrue); //true
        
        isTrue=ostrich instanceof Animal;
        System.out.println("ostrich 是動物(Animal)嗎?" + isTrue); //true
        
        System.out.println("----------------------");
        Bird bird=new Ostrich(); //建立一個Ostrich 實體,指定給Bird 的物件變數
        bird.move(); //Ostrich 的move()
        ((Ostrich)bird).move(); //將bird轉為Ostrich 型別
        
        isTrue=bird instanceof Ostrich; //instanceof用來判斷
        System.out.println("bird 是鴕鳥(Ostrich)嗎?" + isTrue); //true
        
        isTrue=bird instanceof Bird;
        System.out.println("bird 是鳥(Bird)嗎?" + isTrue); //true
        
        isTrue=bird instanceof Animal;
        System.out.println("bird 是動物(Animal)嗎?" + isTrue); //true
        
        System.out.println("----------------------");
        Animal animal2=new Ostrich(); //動物>鴕鳥
        animal2.move();
        ((Ostrich)animal2).move();
        
        //animal2.skill(); //compiler error
        ((Ostrich)animal2).skill(); //OK 轉型成鴕鳥才有技能
        
        isTrue=animal2 instanceof Ostrich; //instanceof用來判斷
        System.out.println("animal2 是鴕鳥(Ostrich)嗎?" + isTrue); //true
        
        isTrue=animal2 instanceof Bird;
        System.out.println("animal2 是鳥(Bird)嗎?" + isTrue); //true
        
        isTrue=animal2 instanceof Animal;
        System.out.println("animal2 是動物(Animal)嗎?" + isTrue); //true
        
        System.out.println("---型別轉換(cast),子轉父,自動轉型---");
        Ostrich ostrich2=new Ostrich();
        Bird bird2=ostrich2;    //子轉父,自動轉型
        Animal animal3=ostrich2;    //子轉父,自動轉型
        
        System.out.println("---型別轉換(cast),父轉子,強迫轉型(無法)---");
        Ostrich ostrich3=new Ostrich();
        Bird bird3=new Bird();    
        Animal animal4=new Animal();
        //Ostrich ostrich4=bird3;    //complier error
        //Ostrich ostrich5=animal4;    //complier error
        //Ostrich ostrich4=(Ostrich)bird3; //父轉子,強迫轉型,執行時會丟出Exception(例外)
        //Ostrich ostrich5=(Ostrich)animal4; //父轉子,強迫轉型,執行時會丟出Exception(例外)
        
        System.out.println("---型別轉換(cast),兄弟轉型(無法)---");
        Dog dog2=new Dog();
        //Lion lion2=dog2; //complier error
        //Lion2 lion=(Dog)dog2; //complier error
        
        isTrue=dog2 instanceof Object;
        System.out.println("dog2 是物件(Object)嗎?" + isTrue); //true
        
    }
    
} //end

//上類別,父類別super class(parent)
class Animal {
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
    
    /*
    覆寫Override 上類別方法:
    1.方法名稱一致
    2.傳回值要一致
    3.修飾子不可小於上類別
    4.參數型別和長度要一致
    */
    
    //1.方法名稱要一致
    @Override //覆寫上類別用
    public void move(){
        System.out.print("我會游來游去");
    }   //正常覆寫
    
    //完全是另一個方法
    public void move2(){} //方法名稱不同
    
    /*
    //2.傳回值要一致
    public int move(){
        return 123;
    } //錯誤:傳回值不一致
    */
    
    //3.修飾子不可小於上類別
    //protectted void move(){}
    //錯誤:上類別Animal是public void move()
    
    //4.參數型別和長度要一致
    //public void move(String id, int abc){}
    //此為多載(Overload)
    
} //Fish end

class Bird extends Animal{
    public static int count=0;

    public Bird(){
        count++;
        System.out.println("我是一隻鳥");    
    }
    @Override //覆寫上類別用
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
    @Override //覆寫上類別用
    public void move(){
        System.out.println("我會跑來跑去");
    }
    public void skill(){
        System.out.println("我跑步超快");
    }
} //Ostrich end
