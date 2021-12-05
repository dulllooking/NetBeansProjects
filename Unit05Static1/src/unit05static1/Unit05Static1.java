package unit05static1;

public class Unit05Static1 {
    static void sub(int x, int y) {
        System.out.print("呼叫Unit05Static1類別的sub方法:");
        System.out.println(x + "-" + y + "=" + (x-y));
    }
    
    public static void main(String[] args) {
        int a=25;
        sub(a-5,3);
        Static2.sub(a+3,5);
    }
}

class Static2 {
    static void sub(int x, int y) {
        System.out.print("呼叫Static2類別的方法:");
        System.out.println(x+"-"+y+"="+(x-y));
    }
}