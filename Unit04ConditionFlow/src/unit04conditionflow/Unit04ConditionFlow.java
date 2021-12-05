/*
 條件式的流程控制(Condition Flow):if,else課本p.3-5~3-7
1.循序
2.條件
3.重複
 */
package unit04conditionflow;
import java.util.Scanner;   //標準輸入文字讀取器,匯入外部類別要放在package下方
import java.text.DecimalFormat; 

public class Unit04ConditionFlow {

    public static void main(String[] args) {
        
        int score=0;
        int age=0;
        Scanner sc=new Scanner(System.in);  //用法可直接從Help查官方文件
        double h=0.0 ,w=0.0 ,bmi=0.0;   //記錄體重,身高,身體質量指數
        String warning="";  //記錄BMI警語
        DecimalFormat df=new DecimalFormat("#,##0.00");
        
        String gender="";
        double sd=0.0;  //紀錄標準體重 
        double up=0.0;  //體重上限
        double down=0.0;   //體重下限
        
        
        
        //及格判斷
        score=49;
        
        System.out.println("---成績判斷---");
        
        //單一條件,單一陳述式
        if(score>=60) System.out.println("PASSED!!");
        
        //單一條件,多重陳述式
        if(score>=60)
            System.out.println("及格!!");
        else
            System.out.println("死當!!");
        
        //多重條件,多重陳述式
        if(score>=60)
            System.out.println("及格!!");
        else if (score>=50)
            System.out.println("補考!!");
        else
            System.out.println("死當!!");
        
        //電影分級
        System.out.println("---電影分級---");
        System.out.print("請輸入您的年齡:");
        age=sc.nextInt();
        
        if(age>=18){
            System.out.println("您今年" + age + "歲了,可以看限制級!!");
            System.out.println("您可以看格雷!");
        }   //兩行以上要用{...}框住才能執行
        else if (age>=15)
            System.out.println("您今年" + age + "歲了,可以看輔15級!!");
        else if (age>=12)
            System.out.println("您今年" + age + "歲了,可以看輔12級!!");
        else if (age>=6)
            System.out.println("您今年" + age + "歲了,可以看保護級!!");
        else {
            System.out.println("您今年" + age + "歲了,可以看普通級!!");
            System.out.println("您只能看角落生物!");
        }   //最後一行{}缺漏錯誤不會提示,變成直接輸出最後一行
        
        
        
        //健康管理系統
        System.out.println("---健康管理---");
        
        System.out.print("請輸入您的身高(公分):");
        h=sc.nextDouble();
        
        System.out.print("請輸入您的體重(公斤):");
        w=sc.nextDouble();
        
        bmi=w/Math.pow(h/100, 2);
        
        if(bmi<18.5)
            warning="太輕";
        else if (bmi<24)
            warning="正常";
        else if (bmi<27)
            warning="過重";
        else if (bmi<30)
            warning="輕肥";
        else if (bmi<35)
            warning="中肥";
        else
            warning="重肥";
        
        
        System.out.println("您的身高為:" + h + "公分");
        System.out.println("您的體重為:" + w + "公斤");
        System.out.println("您的BMI為:" + bmi);
        System.out.println("您的BMI為:" + df.format(bmi));
        System.out.println("警語:" + warning);
        
        System.out.println("---計算標準體重---");
        System.out.print("請輸入您的性別，『 m 』或『 f 』:");
        gender=sc.next().toLowerCase();
        
        //求標準體重
        if (gender.equals("m"))
            sd=(h-80)*0.7;
        else
            sd=(h-70)*0.6;
        
        //求上限
        up=sd*1.1;
        
        //求下限
        down=sd*0.9;
        
        //警語
        if (w>up)
            warning="請減重!!";
        else if (w<down)
            warning="請多吃點!!";
        else
            warning="體重標準~";
        
        System.out.println("性別:" + (gender.equals("m")?"男生":"女生"));
        System.out.println("標準體重:" + df.format(sd));
        System.out.println("上限:" + df.format(up));
        System.out.println("下限:" + df.format(down));
        System.out.println("警語:" + warning);
        
        
        sc.close(); //輸入類,結束後要關掉
        
        
    }
    
}
