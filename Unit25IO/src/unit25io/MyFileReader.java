package unit25io;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
        
public class MyFileReader {
    
    public static void main(String[] args){
    
        String file="ptt.txt";
        char[] buffer=null;
        FileReader fr=null;
        int count=0;
                
        try{
            fr=new FileReader(file); 
            buffer=new char[1]; 
            while(fr.read(buffer) != -1){ //read讀取下一筆資料直到結束回傳-1,故當不等於-1時要一直執行
                System.out.print(buffer);
                count++;
            }
        System.out.println("\n總共:" + count + "個字~");    
        System.out.println("資料讀取完畢!!");    
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
                fr.close();
                System.out.println("程式執行完畢!!");
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
