package unit21collection;
import java.util.*;

public class MyTreeSet {
    //TreeSet 集合
    public static void main(String[] args){
        
        //有排序,無順序,無重覆
        //文件:SortedSet是Interface介面,不能new實體化,由子項實體化再指定給ss
        SortedSet<Integer> ss=new TreeSet<Integer>();
        ss.add(100);
        ss.add(200);
        ss.add(150);
        ss.add(300);
        ss.add(400);
        System.out.println(ss);
        ss.add(150);
        System.out.println(ss);
        ss.add(80);
        System.out.println(ss);
        
        Iterator<Integer> it=ss.iterator();
        int sum=0;
        while(it.hasNext()){
            int temp=it.next();
            sum += temp;
            System.out.println(temp + "," + sum);
        }
        
        System.out.println("總計:" + sum);
        System.out.println("平均:" + sum/ss.size());
        System.out.println("最高值:" + ss.last());
        System.out.println("最低值:" + ss.first());
        
    }
}
