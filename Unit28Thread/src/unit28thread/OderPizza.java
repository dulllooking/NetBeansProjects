package unit28thread;

public class OderPizza {
    
    public static void main(String[] args) {
    
        Pizza pizza=new Pizza();
        //pizza.start(); //error
        
        Thread pt=new Thread(pizza, "必勝客, 請撥打3939889");
        pt.start();
    }
}
