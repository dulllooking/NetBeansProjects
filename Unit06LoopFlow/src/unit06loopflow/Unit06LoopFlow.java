/*
重複流程控制
for 迴圈
for (起始值;終止條件;遞增減)
 */
package unit06loopflow;


public class Unit06LoopFlow {

    public static void main(String[] args) {
        
        int sum=0;
        for(int i=1;i<=10;i++){
            sum +=i;    //sum=sum+i;
            System.out.println("i=" + i + ",sum=" + sum);
        }
        
        System.out.println("1+2+3+...+10=" + sum);
        
        //只有偶數才相加
        System.out.println("----方法1---");
        
        sum=0;
        for(int i=2;i<=100;i+=2){
            sum +=i;    //sum=sum+i;
            System.out.println("i=" + i + ",sum=" + sum);
        }
        
        System.out.println("2+4+6+...+100=" + sum);
        
        System.out.println("----方法2---");
        
        sum=0;
        for(int i=1;i<=100;i++){
          if (i%2==0){  
            sum +=i;    //sum=sum+i;
            System.out.println("i=" + i + ",sum=" + sum);
          }
        }
        
        System.out.println("2+4+6+...+100=" + sum);
        
        System.out.println("----方法3---");
        
        sum=0;
        for(int i=1;i<=100;i++){
          if (i%2==1) continue; //當條件成立時跳出本次迴圈，繼續執行下一個 
          sum +=i;    //sum=sum+i;
          System.out.println("i=" + i + ",sum=" + sum);
        }
        
        System.out.println("2+4+6+...+100=" + sum);
        
        System.out.println("----break---");
        
        sum=0;
        for(int i=1;i<=100;i++){
          if (sum>=2000) break; //當條件成立時,離開迴圈,不會再回來
          sum +=i;    //sum=sum+i;
          System.out.println("i=" + i + ",sum=" + sum);
          
          System.out.println("----break---");
        }
          
        //for練習 
        sum=0;
        for(int i=0;i<11;i++){
            sum +=i;
            System.out.println("i=" + i + ",sum" + sum);
        }
        sum=0;
        for(int i=0;i<11;i++){
            if (i%2==0)continue;
            sum +=i;
            System.out.println("i=" + i + ",sum" + sum);
        }
        sum=0;
        for(int i=0;i<11;i++){
            if(sum >=10)break;
            sum +=i;
            System.out.println("i=" + i + ",sum" + sum);
        }
        
        System.out.println("---巢狀迴圈----");//迴圈內,還有迴圈
        //99乘法
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                int k=i*j;
                System.out.print(i + "x" + j + "=" + k +"\t");//跳脫字元\t=tab
            }//inner
            System.out.println();
        }//outer
        
        //排版練習
        for(int i=1;i<=9;i++){for(int j=1;j<=9;j++){
                int k=i*j;
                //System.out.print(i + "x" + j + "=" + k +"\t");//跳脫字元\t=tab
                //System.out.printf("%dx%d=%2d\t",i,j,k);//printf格式化輸出(C語言),%d整數位
                System.out.format("%dx%d=%2d\t",i,j,k);//format格式化輸出(java),%d整數位
                if (j%3==0) System.out.println();
            }//inner
            System.out.println("-----------------------");
        }//outer
        
        
    }
    
}
