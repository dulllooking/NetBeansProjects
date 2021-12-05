package unit05static1;

public class MyClass {
    void sub(int x, int y) {
        System.out.print("呼叫MyClass類別的sub方法:");
        System.out.println(x+"-"+y+"="+(x-y));
    }
    
    public static void main(String[] args) {
        int a=25;
        MyClass c1=new MyClass();
        c1.sub(a-5, 3);
        MyCal c2=new MyCal();
        c2.sub(a+3, 5);
    }
}

class MyCal {
    void sub(int x, int y) {
        System.out.print("呼叫MyCal類別的sub方法:");
        System.out.println(x+"-"+y+"="+(x-y));
    }
}