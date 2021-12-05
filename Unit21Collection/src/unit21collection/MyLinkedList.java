package unit21collection;
import java.util.*;

public class MyLinkedList {
    
    public static void main(String[] args){
        
        //有順序,有重覆,有索引值
        LinkedList<String> ll=new LinkedList<String>();
        ll.add("澄清湖");
        ll.add("天母");
        ll.add("桃園");
        ll.add("台中");
        ll.add("台南");
        
        System.out.println(ll);
        
        ll.add("立德");
        System.out.println(ll);
        
        ll.add(4,"澄清湖"); //指定新增至第幾個
        System.out.println(ll);
        
        System.out.println("第三個:" + ll.get(3));
        System.out.println("最後一個:" + ll.getLast());
        System.out.println("第一個:" + ll.getFirst());
        System.out.println("-----------------------");
        
        Iterator<String> it=ll.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();
        System.out.println("-----------------------");
        
        //stack(堆疊),後進先出
        ll.push("台東"); //推入,置入
        System.out.println(ll);
        
        System.out.println("-----------------------");
        ll.pop(); //取出
        ll.pop(); //取出
        System.out.println(ll);
        
    }
}
