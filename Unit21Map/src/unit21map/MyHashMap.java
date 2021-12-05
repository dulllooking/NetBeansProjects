package unit21map;
import java.util.*;

public class MyHashMap {
    public static void main(String[] args){
        //key值不重覆,無排序
        HashMap<Integer,Employee> hm=new HashMap<>();
        
        hm.put(111, new Employee("001", "科及爸"));
        
        Employee emp1=new Employee("002", "愛台晚");
        Employee emp2=new Employee("003", "愛使你");
        
        hm.put(33,emp1);
        hm.put(222,emp2);
        System.out.println(hm);
        
        hm.put(555, new Employee("000", "愛闢愛"));
        //hm.put(666, null); //null可使用,但Employee沒寫所以無法使用
        //hm.put(null, null);
        //hm.put(null, new Employee("004", "沒良心"));
        hm.put(555, new Employee("005", "有良心"));
        System.out.println(hm);
        
        System.out.println("--------Iterator-走訪器-------");
        Iterator<Map.Entry<Integer, Employee>> it=hm.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Employee> temp=it.next();
            System.out.println(temp.getKey() + "=>" + temp.getValue().getIdName());
        }
    }
}
