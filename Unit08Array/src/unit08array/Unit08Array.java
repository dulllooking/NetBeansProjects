/*
陣列 Array
 */
package unit08array;

public class Unit08Array {

    public static void main(String[] args) {
        
        //宣告整數型別的陣列
        int score[]; //ok
        int[] score2[]; //ok 2D陣列
        int[] score3; //ok
        String[] name=new String[4];
        char grade[];
        int n=0;
        
        int postCode[];
        
        score=new int[5]; //5元素的陣列,索引值5,5個索引編號:0,1,2,3,4
        
        score[0]=100;
        score[1]=50;
        score[2]=60;
        score[3]=80;
        score[4]=90;
        
        //score[5]=89; //執行會錯誤超出ArrayIndexOutOfBoundsException:5的索引數量上限
        //語法不會糾錯,但執行會出錯
        
        System.out.println("score[0]=" + score[0]);
        System.out.println("score[1]=" + score[1]);
        System.out.println("score[2]=" + score[2]);
        System.out.println("score[3]=" + score[3]);
        System.out.println("score[4]=" + score[4]);
        
        
        name[0]="張天天";
        name[1]="王天天";
        name[2]="陳天天";
        name[3]="李天天";
        
        //使用for迴圈輸出學生資料
        System.out.println("---for 輸出---");
        System.out.println("共有" + name.length + "位學生"); //length自動算長度
        for(int i=0;i<name.length;i++){ //用length避免算錯數量
            System.out.println("name[" + i + "]=" + name[i]);
        }
        
        //使用while迴圈輸出學生資料
        System.out.println("---while 輸出---");
        while(n<name.length){
            System.out.println("name[" + n + "]=" + name[n]);
            n++;
        }
        
        //---練習---
        System.out.println("---一般輸出---");
        grade =new char[3];
        grade[0]='A';
        grade[1]=65;
        grade[2]='\u0041';
        System.out.println("grade[0]=" + grade[0]);
        System.out.println("grade[1]=" + grade[1]);
        System.out.println("grade[2]=" + grade[2]);
        
        System.out.println("---for迴圈輸出---");
        for (int i=0;i<grade.length;i++)
            System.out.println("grade[" + i + "]=" + grade[i]);
        
        System.out.println("---for each輸出---");
        for(char e:grade)   //每一個都輸出
            System.out.println(e);
        
        //宣告一陣列紀錄高雄38個行政區郵遞區號800~837並輸出全部
        postCode = new int[38];
        for (int i=0;i<postCode.length;i++)
            postCode[i] = 800+i;
        for (int e:postCode)
            System.out.println("郵遞區號:" + (e));
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
