
package unit15extends;
//兩個class main
//修改專案主程式main所在類別:專案Unit15Extends右鍵Properties>Run>Main Class>Browse>修改
public class Zoo {
    public static void main(String[] args){
       
        Animal animal=new Animal();
        Animal animal2=new Animal();
        animal.move();
        
        System.out.println("---------------------------");
        Dog dog=new Dog();
        
        System.out.println("---------------------------");
        Lion lion=new Lion();
        
        System.out.println("---------------------------");
        Fish fish=new Fish();
        fish.move();
        
        System.out.println("---------------------------");
        Bird bird=new Bird();
        bird.move();
        
        System.out.println("---------------------------");
        Ostrich ostrich=new Ostrich();
        ostrich.move();
        ostrich.skill();
        
        Ostrich ostrich2=new Ostrich();
        
        System.out.println("---------------------------");
        System.out.println("動物園裡有" + Animal.count + "隻動物"); //8
        System.out.println("動物園裡有" + Dog.count + "隻小狗"); //1
        System.out.println("動物園裡有" + Lion.count + "隻獅子 "); //1
        System.out.println("動物園裡有" + Fish.count + "隻魚"); //1
        System.out.println("動物園裡有" + Bird.count + "隻小鳥"); //3
        System.out.println("動物園裡有" + Ostrich.count + "隻鴕鳥"); //2
        
    }
}
