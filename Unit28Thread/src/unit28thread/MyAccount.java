package unit28thread;

public class MyAccount {
    
    public static void main(String[] args) {
        
        Account a1=new Account(2000);
        Account a2=new Account(1000);
        Account a3=new Account(1500);
        
        try{
            ATM atm1=new ATM(a1, 500);    
            atm1.start();
            atm1.join();
            
            ATM atm2=new ATM(a2, -1500);
            atm2.start();
            atm2.join();
            
            ATM atm3=new ATM(a3, 800);
            atm3.start();
            atm3.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
