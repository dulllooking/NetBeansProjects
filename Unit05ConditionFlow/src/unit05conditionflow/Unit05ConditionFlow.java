/*
 條件式的流程控制(Condition Flow):switch,case課本p.3-5~3-7
1.循序
2.條件
3.重複
 */
package unit05conditionflow;
import java.util.Scanner;


public class Unit05ConditionFlow {

    public static void main(String[] args) {
        
        int webNo=0;
        int month=0;
        String webSite="";
        Scanner sc=new Scanner(System.in);
        
        String season="";
        String trip="";
        
        
        
        //換行跳脫字元\n
        System.out.print(" 1:Google\n 2:Yahoo\n 3:Pchome\n 4:Youtube\n 請輸入您最喜愛的網站代號:");
        webNo=sc.nextInt();
        
        switch (webNo){
            case 1:
                webSite="Google";
                break;  //沒有加break會一直跑到最後輸出default
            case 2:
                webSite="Yahoo";
                break;
            case 3:
                webSite="Pchome";
                break;
            case 4:
                webSite="Youtube";
                break;
            default :
                webSite="沒有這個網站";
        }
        
        System.out.println("您最喜愛的網站是:" + webSite);
        
        System.out.println("--------------------------------");
        
        System.out.print("請輸入季節名稱\n spring,summer,fall,winter : ");
        season=sc.next().toLowerCase();
        
        
        switch (season){
            case "spring":
                trip="春天,阿里山賞櫻去";
                break;  //沒有加break會一直跑到最後輸出default
            case "summer":
                trip="夏天,墾丁戲水去";
                break;
            case "fall":
                trip="秋天,奧萬大賞楓去";
                break;
            case "winter":
                trip="冬天,關仔嶺泡湯去";
                break;
            default :
                trip="沒有這個季節";
        }
        
        System.out.println("季節:" + season);
        System.out.println("建議行程:" + trip);
        
        System.out.println("--------------------------------");
        
        System.out.print("請輸入您想去旅遊的月份 : ");
        month=sc.nextInt();
        
        switch (month){
            case 1:
            case 2:
            case 3:
                season="spring";
                trip="春天,阿里山賞櫻去";
                break;
            case 4:
            case 5:
            case 6:
                season="summer";
                trip="夏天,墾丁戲水去";
                break;
            case 7:
            case 8:
            case 9:
                season="fall";
                trip="秋天,奧萬大賞楓去";
                break;
            case 10:
            case 11:
            case 12:
                season="winter";
                trip="冬天,關仔嶺泡湯去";
                break;
            default :
                trip="沒有這個月份";
        
        }
        
        System.out.println(month + "月-季節:" + season);
        System.out.println("建議行程:" + trip);
        
        
        
        sc.close(); //輸入類,結束後要關掉
 

    }
    
}
