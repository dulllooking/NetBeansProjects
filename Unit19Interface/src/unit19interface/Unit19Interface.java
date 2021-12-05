package unit19interface;

public class Unit19Interface {
/*
* 程式名稱 : Interface 介面的說明    
*/
    public static void main(String[] args) {
        
        Tank t=new Tank();
        
        //IRake ir=new IRake(); //介面,無法實體
        
        SuperTank st=new SuperTank();
        st.rake();
        st.swim();
        st.blowUp();
        
    }
    
}
