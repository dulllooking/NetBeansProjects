package unit25io;
import java.io.*;
import java.util.Scanner;

public class NewsWriter {
    
    public static void main(String[] args) throws IOException{
        //Scanner scn=new Scanner(System.in,"UTF-8"); //中文亂碼用
        Scanner scn=new Scanner(System.in);
        String news="";
        File file=new File("news.txt");
        if(file.exists())
            System.out.println("news.txt 檔案已存在");
        else
            if(file.createNewFile())System.out.println("news.txt 檔案建立成功!!");
            
        System.out.println("請輸入八卦新聞:");
        while(true){
            news=scn.next();
            if(news.equalsIgnoreCase("quit"))break;
            
            //接水管
            FileOutputStream fos=new FileOutputStream(file, true);
            
            //裝馬達,編碼用 (第二參數可指定編碼)
            OutputStreamWriter osw=new OutputStreamWriter(fos);
            
            //接水桶,緩衝暫存資料
            BufferedWriter bw=new BufferedWriter(osw);
            
            bw.write(news + "\n"); //寫入
            bw.flush(); //清空緩衝區
            
            bw.close();
            osw.close();
            fos.close();
        }
        scn.close();
    }
}
