
package unit12method;
import java.util.Scanner;
/*
 * 程式名稱 : Method(方法)的宣告與使用 
 */
public class Unit12Method {

    public static void main(String[] args) {
        //main(主程式)
        
        //呼叫method方法
        //1.呼叫無參數,無回傳值
        System.out.println("---1.呼叫無參數,無回傳值---");
        myGame();
        
        //2.呼叫有參數,無傳回值
        //yourGame(123); //非字串
        System.out.println("---2.呼叫有參數,無回傳值---");
        yourGame("植物大戰殭屍"); //method宣告yourGame接收字串
        yourGame("動物森友會");
        
        //2-1.練習
        System.out.println("---2-1.練習---");
        playerJob(1);
        playerJob(3);
        
        //3.無參數,有傳回值
        System.out.println("---3.無參數,有傳回值---");
        int playerPow=hisGame();
        System.out.println("他的戰鬥力是" + playerPow);
        
        //4.有參數,有傳回值
        System.out.println("---4.有參數,有傳回值---");
        int playerPow2=herGame(60,70,90); //需填值
        System.out.println("她的戰鬥力是" + playerPow2);
        System.out.println("她的職業是" + playerJob2(2));
        
        //5.呼叫不定參數長度之方法
        System.out.println("---5.呼叫不定參數長度之方法---");
        desposit("真有錢",10,5,100,50,3200);
        
        //6.呼叫傳址函數
        System.out.println("---6.呼叫傳址函數---");
        int counter=10; //Stack Memory
        int[] grade={10,20};
        System.out.println("呼叫傳址函數之前");
        System.out.println("grade[0]" + grade[0]); //10
        System.out.println("grade[1]" + grade[1]); //20
        System.out.println("呼叫傳址函數");
        callRef(grade); //100,90
        System.out.println("呼叫傳址函數之後");
        System.out.println("grade[0]" + grade[0]);  //100
        System.out.println("grade[1]" + grade[1]);  //90
        
    }
    //有void就不用return
    //宣告方法
    //1.無參數:主程式()內為空,無傳回值:不會出現retune(void)
    public static void myGame(){
        System.out.println("~~歡迎來到遊戲世界~~");
    }
    
    //2.有參數,無傳回值
    public static void yourGame(String gameName){
        System.out.println("~~你最喜愛的遊戲是" + gameName + "~~");
    }
    
    //2-1.練習
    public static void playerJob(int gameRole){
        String job="";
        switch(gameRole)
        {
            case 1:
                job="小偷";
                break;
            case 2:
                job="勇士";
                break;
            case 3:
                job="法師";
                break;
            case 4:
                job="弓箭手";
                break;    
            default:
                job="無此職業";
        }
        System.out.println("你的職業是:" + job);
    }
    
    //3.無參數,有傳回值(非void)
    public static int hisGame(){
        int hp=100;
        int mp=50;
        int sp=60;
        
        return (hp*1 + mp*2 + sp*3);
        
    }
    
    //4.有參數,有傳回值
    public static int herGame(int hp, int mp ,int sp){
        return (hp*1 + mp*2 + sp*3); 
    }
    
    public static String playerJob2(int i){
        String job="";
        switch(i)
        {
            case 1:
                job="小偷";
                break;
            case 2:
                job="勇士";
                break;
            case 3:
                job="法師";
                break;
            case 4:
                job="弓箭手";
                break;    
            default:
                job="無此職業";
        }
        return job;
    }

    //不定參(引)數長度
    //public static void desposit(int...num,String name){ //error,因為不定長度參數要置於最後位置
    public static void desposit(String name,int...num){ //...三個點為參數不確定時使用,需置於後方
        
        int sum=0;
        for(int e:num){
            sum +=e;
            System.out.println("e=" + e + ",sum" + sum);
        }
        System.out.println(name + "-存款總額是:$" + sum);
    }
    
    //陣列傳址函數
    public static void callRef(int[] score){
        score [0]=100;
        score [1]=90;
        System.out.println("score[0]" + score[0]);
        System.out.println("score[1]" + score[1]);
    }
    
}
