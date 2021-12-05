package unit21collection;
import java.util.*;

public class MyArrayList {
    
    public static void main(String[] args){
        
        //有順序,可重覆,有索引值
        //ArrayList<String> al=new ArrayList<String>();
        ArrayList al=new ArrayList();
        
        al.add("高雄");
        al.add(123);
        al.add(123.123);
        al.add('A');
        al.add(2,"屏東");
        
        System.out.println(al);
        al.add("高雄");
        System.out.println(al);
        
    }
        
}
