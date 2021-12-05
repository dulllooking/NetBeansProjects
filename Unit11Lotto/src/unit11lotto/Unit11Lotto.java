
package unit11lotto;
import java.util.Arrays;
/*
 樂透(綜合練習)
 */
public class Unit11Lotto {

  
    public static void main(String[] args) {
        int[] lotto=new int[6]; //記錄樂透的6個值
        int lucky=0;    //記錄每次產生的亂數
        int i=0;    //記錄迴圈次數
        boolean flag=false; //記錄lucky是否有等於lotto內的值
        
        do
        {
            lucky=(int)Math.floor(Math.random()*49)+1;
            flag=false;
            for(int j=0;j<i;j++)
            {   //比對lotto元素值是否有等於lucky值
                if(lotto[j]==lucky)
                {
                    System.out.print("*" + lucky + " ");
                    flag=true;
                    break;
                }
            }
            if(!flag)
            {
                System.out.print(lucky + " ");
                lotto[i]=lucky;
                i++;
            }
        }while(i<lotto.length);
        
        System.out.println("\n---樂透的值,排序前---");
        for(int e:lotto)
            System.out.print(e + " ");
        
        Arrays.sort(lotto);
        System.out.println("\n---樂透的值,排序後---");
        for(int e:lotto)
            System.out.print(e + " ");
    }
    
}
