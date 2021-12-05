
package unit09array2d;
import java.util.Arrays;
/*
 *2維陣列
 */
public class Unit09Array2D {

    public static void main(String[] args) {
        //宣告陣列方法1
        //int score[][];    //ok
        int[][]score; //ok
        //int[] score[]; //ok
        
        score=new int[2][3];
        score[0][0]=70;     score[0][1]=80;     score[0][2]=90;
        score[1][0]=85;     score[1][1]=78;     score[1][2]=65;
        
        //宣告陣列方法2 
        //陣列型態[]陣列名稱={};
        String[]city[]={
            {"新北","侯友宜","男"},
            {"台北","柯文哲","男"},
            {"桃園","鄭文燦","男"},
            {"台中","盧秀燕","女"},
            {"台南","黃偉哲","男"},
            {"高雄","陳其邁","男"}
        };
        //一維寫法
        String[] test={"新北","侯友宜","男"};
        
        //不對稱的陣列
        char[][] grade=new char[2][];
        grade[0]=new char[3];
        grade[1]=new char[4];
        grade[0][0]='上';
        grade[0][1]='A';
        grade[0][2]='B';
        grade[1][0]='下';
        grade[1][1]='A';
        grade[1][2]='C';
        grade[1][3]='B';
        
        //
        String[]baseball[]={
            {"台灣","兄弟","富邦","統一","桃猿"},
            {"日本","巨人","火腿","軟銀"},
            {"美國","洋基","馬林","光茫","道奇"}
        };
        
        
        System.out.println("score[0][0]:" + score[0][0]);
        
        System.out.println("---for巢狀迴圈輸出---");
        for (int i=0;i<score.length;i++)
        {
            for (int j=0;j<score[i].length;j++)
            {
                System.out.print("score[" + i + "][" + j + "]:" + score[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("---for each輸出---");
        for (int[] e:score) //for (int e[]:score)
        {
            for(int ee:e)
            {
            System.out.print(ee+"\t");
            }
        System.out.println();
        }
        
        for(String[] e:city)
        {
            for(String ee:e)
            {
                System.out.print(ee+"\t");
            }
            System.out.println();
        }
        
        System.out.println("---上下學期學分成績---");
        for(int i=0;i<grade.length;i++)
        {
            for(int j=0;j<grade[i].length;j++)
            {
                System.out.print(grade[i][j]+"");
            }
            System.out.println();
        }
        
        System.out.println("---世界棒球隊---");
        System.out.println("baseball是不是陣列:" + baseball.getClass().isArray()); //true
        System.out.println(baseball); //16進制hashcode
        System.out.println(baseball.hashCode()); //十進制hashcode
        for(String[] e:baseball)
        {
            System.out.println(e); //雜湊碼hashcode 陣列需轉字串才能印出來
            System.out.println(Arrays.toString(e)); //需import java.util.Arrays;
            System.out.println("e是不是一個陣列:" + e.getClass().isArray()); //true
            for(String ee:e)
            {
                System.out.print("ee是不是一個陣列:" + ee.getClass().isArray()+"/"); //fale
                System.out.println(ee);
            }
        }
    }
    
    
}
