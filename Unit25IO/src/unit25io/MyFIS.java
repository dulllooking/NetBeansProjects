package unit25io;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
        
public class MyFIS {

    public static void main(String[] args){
        
        String file="ptt.txt";
        int totalBytes=0;
        byte[] buffer=null;
        FileInputStream fis=null;
        
        try{
            fis=new FileInputStream(file); //官方文件關鍵字FileInputStream
            totalBytes=fis.available(); //取得檔案大小bytes數值
            System.out.println(file + "檔案,共計:" + totalBytes + "bytes");
            buffer=new byte[totalBytes]; //將檔案大小(bytes)作為buffer陣列的元素數
            while(fis.read(buffer) != -1){ //read讀取下一筆資料直到結束回傳-1,故當不等於-1時要一直執行
                String str=new String(buffer);
                System.out.println(str);
            }
        System.out.println("資料讀取完畢!!");    
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                fis.close();
                System.out.println("程式執行完畢!!");
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
