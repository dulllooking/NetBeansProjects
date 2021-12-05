package unit30recursion;

//Recursion,遞迴,不斷地呼叫自己,可能產生無窮迴圈,所以需要條件跳離迴圈
public class Unit30Recursion {

    //最大公因(約)數
    public static int gcd(int i, int j){
        
        if(j==0)
            return i; //跳離迴圈用,當i%j為0時
        else
            return gcd(j,i%j);
    }
    
    public static void main(String[] args) {
        
        int i=46, j=6;
        System.out.println("最大公因(約)數 gcd() : " + gcd(i,j));
        //System.out.println("某數的階層factoral() : " + factoral(5));
    }
    
    
    /*
    //某數的階層
    public static int factoral(int i){
        
        if(i==1)
            return 1;
        else
            return i*factoral(i-1);
    }
*/
}
