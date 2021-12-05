package unit31jar;
import unit28thread.Pizza;

public class Unit31JAR {

    public static void main(String[] args) {
        Pizza pizza=new Pizza();
        
        Thread pt=new Thread(pizza, "必勝客, 請撥打3939889");
        pt.start();
    }
    
}
