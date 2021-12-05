/*
重複流程控制
while  (相較於for而言,while用在不確定結束點時)
do...while
 */
package unit07loopflow;
import java.util.Scanner;

public class Unit07LoopFlow {

    public static void main(String[] args) {
    
    int i=0;
    int sum=0;
    int n=0;
    int count=0; //記錄迴圈執行的次數
    
    double r=0.0;
    double c=0.0;
    double f=0.0;
    double lucky=0.0;
    double salary=0.0;
    
    String no="";
    String name="";
    String quit="";
    
    Scanner sc=new Scanner (System.in);
    
    System.out.println("---while-1-前測---");
    while(i<10){    //條件成立,才會執行區塊內的敘述
        i++;    //若未加此行會造成無窮迴圈
        sum +=i;
        System.out.printf("i=%d sum=%d%n", i,sum);  //%d=\d
        }
    
    i=1;
    sum=0;
    System.out.println("---while-2---");
    while(i<=10){    //條件成立,才會執行區塊內的敘述
        sum +=i;
        System.out.printf("i=%d sum=%d%n", i,sum);  //%d=\d
        i++;
        }
    i=0;
    sum=0;
    System.out.println("---while-3---");
    while(true){    //條件成立,才會執行區塊內的敘述
        i++;
        sum +=i;
        System.out.printf("i=%d sum=%d%n", i,sum);  //%d=\d
        if(i==10)break;
        }
    
    System.out.println("---do...while-後測---");
    i=0;
    sum=0;
    do{
        i++;
        sum +=i;
        System.out.printf("i=%d sum=%d%n", i,sum);  //%d=\d
        if(i==10)break;
        }while(i<10);
    
    System.out.println("---while與do...while-之差異---");
    
    //前測,先判斷,再執行,有可能一次都沒有被執行
    while(n<0){
        System.out.println("這是while區塊,我被執行了");
    }
    do{
        System.out.println("這是do...while區塊,我被執行了");
        }while(n<0);
    
    System.out.println("---亂術與迴圈的應用---");
    r=Math.random(); //0.0~小於1.0的浮點數,>=0~<1.0
    c=Math.ceil(r); //ceil天花板,最接近,但大於小數的最小整數
    f=Math.floor(r); //floor地板,最接近,但小於小數的最大整數
    System.out.println("r=" + r);
    System.out.println("c=" + c);
    System.out.println("f=" + f);
    
    //假設要取1~49
    c=Math.ceil(r*48)+1; //+1為避免值是0
    f=Math.floor(r*49)+1; //+1為避免值是0
    
    System.out.println("Math.ceil(r*48)+1=" + c);
    System.out.println("Math.floor(r*49)+1=" + f);
    
    System.out.println("---取6個1~49---");
    System.out.print("樂透號碼:");
    for(int a=1;a<=6;a++){
        r=Math.random();
        lucky=Math.ceil(r*48)+1;
        System.out.print((int)lucky + "\t");
        }
    System.out.println("\n" + "---取1~49之數值,直到數值12出現---");
    System.out.print("幸運號碼:");
    while(true){
        count++;
        r=Math.random();
        lucky=Math.ceil(r*48)+1;
        System.out.print((int)lucky + "\t");
        if(lucky==12)break;
        }
    System.out.println("\n" + "幸運迴圈執行次數:" + count);
    
    System.out.println("---員工資料管理系統,請使用者輸入多筆資料,輸入q則結束輸入---");
    count=0;
    while(true){
        System.out.print("請輸入員工編號:");
        no=sc.next();
        if(no.equals("q")||no.equals("Q"))break;
        System.out.println("員工編號:" + no);
        System.out.print("請輸入員工姓名:");
        name=sc.next();
        if(name.toLowerCase().equals("q"))break;
        System.out.println("員工姓名:" + name);
        //例外處理
        try{
        System.out.print("請輸入員工薪資:");
        salary=sc.nextDouble();
        //if(salary.equals("q"))break; //salary不是字串會錯誤
        System.out.println("員工薪資:$" + salary);
        }catch(Exception e){
            break;
        }
        
        count++;
        System.out.println("第" + count + "位員工資料:");
        System.out.println("員工編號:" + no);
        System.out.println("員工姓名:" + name);
        System.out.println("員工薪資:$" + salary);
        System.out.println("--------------------------");
        }
    System.out.println("已輸入員工資料數量:" + count);
    System.out.println("881~");
    
    
    System.out.println("---員工資料管理系統2,連續輸入---");
    count=0;
    while(true){
        System.out.print("請輸入員工編號:");
        no=sc.next();
        System.out.println("員工編號:" + no);
        
        System.out.print("請輸入員工姓名:");
        name=sc.next();
        System.out.println("員工姓名:" + name);
        
        //例外處理...Exception(例外)...try...catch...
        try{
        System.out.print("請輸入員工薪資:");
        salary=sc.nextDouble();
        System.out.println("員工薪資:$" + salary);
        }catch(Exception e){
            break;
            }
        System.out.print("若要繼續請[y],若要離開請按[n]:");
        quit=sc.next().toLowerCase();
        if(quit.equals("n")){
            System.out.println("881~");
            break;
        }
        
        count++;
        System.out.println("第" + count + "位員工資料:");
        System.out.println("員工編號:" + no);
        System.out.println("員工姓名:" + name);
        System.out.println("員工薪資:$" + salary);
        System.out.println("--------------------------");
        }
    System.out.println("已輸入員工資料數量:" + count);
    
    sc.close(); //輸入類,結束後要關掉
    /*
    System.out.println(Math.ceil(12.45)); //13
    System.out.println(Math.floor(12.45)); //12
    
    System.out.println(Math.ceil(-12.45)); //-12
    System.out.println(Math.floor(-12.45)); //-13
    */
    }
    
}
