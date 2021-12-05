package unit21map;
import java.util.*;

public class MyTreeMap {
    
    public static void main(String[] args) {
        //有排序,Key鍵無重覆,Value值可重覆
        TreeMap<Integer,String> tm=new TreeMap<Integer,String>();
        TreeMap<String,String> tm2=new TreeMap<>(); //後方可省
        //<>diamond operator
        
        tm.put(1001, "王建民");
        tm.put(1002, "陳偉殷");
        tm.put(1003, "恰恰");
        tm.put(1004, "郭泓志");
        System.out.println(tm);
        
        tm.put(1000, "林益全");
        System.out.println(tm);
        
        tm.put(1005, "林益全");
        System.out.println(tm);
        
        System.out.println("--------------------");
        tm2.put("F01","蘋果");
        tm2.put("F02", "鳳梨");
        System.out.println(tm2);
        //以key記錄值,key不重覆
        tm2.put("F03", "香蕉");
        System.out.println(tm2);
        //以key記錄值,key不重覆,value可重覆
        tm2.put("F03", "橘子");
        System.out.println(tm2);
        
        tm2.put("F05", "西瓜");
        tm2.put("F06", "荔枝");
        System.out.println(tm2);
        //有排序(自動排序)
        tm2.put("F04", "釋迦");
        System.out.println(tm2);
        
        System.out.println("--------for each-------");
        //for(Map.Entry<String,String> e:tm2.entrySet()) {
        tm2.entrySet().forEach((e) -> { //官方建議寫法
            System.out.println(e.getKey() + "=>" + e.getValue()); //取key,取value
        }); //Alt+Enter可使用官方建議寫法
        
        System.out.println("--------Iterator-走訪器-------");
        Iterator<Map.Entry<Integer,String>> team=tm.entrySet().iterator();
        while(team.hasNext()){
            Map.Entry<Integer,String> temp=team.next();
            System.out.println(temp.getKey() + "=>" + temp.getValue());
        }
    } 
}
