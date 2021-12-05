package unit28thread;

public class SnoopyEarsPizza {
    
    public static void main(String[] args) {
        Snoopy snoopy=new Snoopy();
        
        Thread ts=new Thread(snoopy);
        ts.start();
    }
}
