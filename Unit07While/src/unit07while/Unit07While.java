package unit07while;
import java.util.Scanner;

public class Unit07While {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int score = 0;
        int sum = 0;
        int num = 0;
        while (score != -1) {
            System.out.print("請輸入分數 (輸入-1結束):");
            score = scn.nextInt();
            if(score != -1) {
                sum += score;
                num++;
            }
        }
        System.out.printf("平均分數 = " + (double)((sum+1) / num));
        scn.close();
    }
}
