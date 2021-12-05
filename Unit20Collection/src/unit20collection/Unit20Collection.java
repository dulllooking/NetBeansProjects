package unit20collection;

import java.util.*;

/*
*程式名稱: Collection 集合
*/

public class Unit20Collection {

    public static void main(String[] args) {
        
        double d=123.45; //基本型別
        Double dd=new Double(12.345); //封裝型別Wrapper Class
        
        //集合HashSet:無順序,無排序,無重覆
        //<泛型>要使用Wrapper
        HashSet<String> hs=new HashSet<String>();
        HashSet<Double> hs2=new HashSet<Double>();
        HashSet<Employee> hs3=new HashSet<Employee>();
        
        Employee emp1=new Employee("0001","恰恰");
        Employee emp2=new Employee("0002","王建民");
        Employee emp3=new Employee("0003","郭泓志");
        Employee emp4=new Employee("0004","陳偉殷");
        
        //宣告自訂泛型類別型別物件
        MyGeneric<Character> mg=new MyGeneric<Character>(); //<character>字元泛型
        MyGeneric<Employee> mg2=new MyGeneric<Employee>(); //自訂泛型
        
        //集合內容練習
        System.out.println("---我最愛的棒球員---");        
        hs.add("王建民");
        hs.add("恰恰");
        hs.add("郭泓志");
        
        System.out.println(hs);
        
        hs.add("陳金鋒");
        hs.add("陳偉殷");
        
        System.out.println(hs);
        
        hs.remove("王建民");
        
        System.out.println(hs);
        
        //無重覆
        hs.add("陳金鋒");
        hs.add("陳偉殷");
        System.out.println(hs);
        
        //走訪HashSet
        Iterator<String> it=hs.iterator(); //將hs傳回的元素指定給疊代器Iterator 型別之it 變數
        System.out.println(it); //只印出記憶體位置
        while(it.hasNext()){ //hasNext回傳true表示還有元素
            System.out.println(it.next()); //next回傳下個元素
        }
        
        System.out.println("---基本型別和Wrapper Class---");
        System.out.println(d);
        System.out.println(dd);
        
        System.out.println("---棒球球員打擊率---");
        hs2.add(0.123);
        hs2.add(0.456);
        hs2.add(0.789);
        hs2.add(0.324);
        System.out.println(hs2);
       
        //走訪
        Iterator<Double> it2=hs2.iterator(); //將hs傳回的元素指定給Iterator 型別之it 變數
        System.out.println(it2); //只印出記憶體位置
        while(it2.hasNext()){ //hasNext回傳true表示還有元素
            System.out.println(it2.next()); //next回傳下個元素
        }
        
        System.out.println("---球員與球員編號---");
        hs3.add(emp1);
        hs3.add(emp2);
        hs3.add(emp3);
        hs3.add(emp4);
        hs3.add(new Employee("0005","陳金鋒"));
        
        Iterator<Employee> it3=hs3.iterator(); //將hs傳回的元素指定給Iterator 型別之it 變數
        while(it3.hasNext()){ //hasNext回傳true表示還有元素
            //System.out.println(it3.next().getIdName()); //Employee method //OK
            Employee e=it3.next(); 
            System.out.print("球員編號:" + e.getId() + ",球員姓名:" + e.getName() + "\n");
        } //暫存作法
        
        System.out.println("---自訂泛型之操作---");
        //自訂泛型之操作,MyGeneric
        mg.setField('A'); 
        char grade=mg.getField();
        System.out.println("grade=" + grade);
        
        mg2.setField(new Employee("0010","林木伊朗"));
        System.out.println("編號:" + mg2.getField().getId());
        System.out.println("姓名:" + mg2.getField().getIdName());
        
    }
    
}
