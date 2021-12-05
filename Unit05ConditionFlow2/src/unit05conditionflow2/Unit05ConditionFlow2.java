/*
 條件式的流程控制(Condition Flow):switch,case課本p.3-5~3-7
1.循序
2.條件
3.重複
 */
package unit05conditionflow2;
import java.util.Scanner; //請使用者輸入資料
import java.util.Calendar;  //日曆

public class Unit05ConditionFlow2 {

    public static void main(String[] args) {
        
        
        int month=0; //月
        int year=0; //年
        int numDay=0;   //每月天數
        
        String leapYear=""; //閏年
        Scanner sc=new Scanner(System.in);
        Calendar cld=Calendar.getInstance();
        
        int week=0;
        String jingle="";
        
        /*
        System.out.println("----閏年判斷----");
        System.out.print("請輸入西元年 : ");
        year=sc.nextInt();
        System.out.print("請輸入月份 : ");
        month=sc.nextInt();
        */
        
        year=cld.get(Calendar.YEAR);
        month=cld.get(Calendar.MONTH)+1;    //官方文件月份1月回傳0,所以要加1
        week=cld.get(Calendar.DAY_OF_WEEK)-1;   //官方文件星期天回傳1,所以要減1
        
        
        //System.out.println(year);
        //System.out.println(month);
        //System.out.println(week);
        
        if(((year%4==0)&&(year%100!=0))||(year%400==0))
            leapYear="閏年";
        else
            leapYear="不是閏年";
        
        
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDay=31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDay=30;
                break;
            case 2:
                if(((year%4==0)&&(year%100!=0))||(year%400==0)){
                    numDay=29;
                    leapYear="閏年";
                break;
                }   //兩行以上要打{}
                else
                    numDay=28;
                    leapYear="不是閏年";
                break;
            default :
                System.out.println("請輸入正常年月數字");
                
                
        }
        System.out.println("年份 : " + year + "年");
        System.out.println("月份 : " + month + "月");
        System.out.println(month + "月天數 : " + numDay + "天");
        System.out.println("是否為閏年 : " + leapYear);
        
        System.out.println("-------------------------------------");
            switch (week){
                case 1:
                    jingle="星期一,猴子穿新衣";
                    break;
                case 2:
                    jingle="星期二,猴子肚子餓";
                    break;
                case 3:
                    jingle="星期三,猴子去爬山";
                    break;
                case 4:
                    jingle="星期四,猴子去考試";
                    break;
                case 5:
                    jingle="星期五,猴子去跳舞";
                    break;
                case 6:
                    jingle="星期六,猴子去斗六";
                    break;
                case 0:
                    jingle="星期七,猴子刷油漆";
                    break;      
            }
            System.out.println(jingle);
            
        //sc.close(); //輸入類,結束後要關掉
 

    }
    
}
