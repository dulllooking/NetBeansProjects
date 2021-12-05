package unit25io;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
    
    public static void main(String[] args){
        String gassip="來點八卦!!\n";
        FileWriter fw=null; //區域變數
        
        try{
            fw=new FileWriter("dcard.txt",true);
            fw.write(gassip); //寫入
            fw.flush(); //緩衝
            System.out.println("資料寫入OK");
        }catch(IOException e){
            e.printStackTrace(); //堆疊追蹤用來查找錯誤
        }finally{
            try{
                fw.close();
                System.out.println("程式執行完畢");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
    }
}
