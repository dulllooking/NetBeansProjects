package unit25io;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
        
public class MyFIB {
    
    public static void main(String[] args){
        
        File file=new File("ptt.txt");
        FileInputStream fis=null;
        InputStreamReader isr=null;
        BufferedReader br=null;
        
        if(file.exists()){ //找水源
            try{
                fis=new FileInputStream(file); //接水管
                isr=new InputStreamReader(fis); //裝馬達,解碼
                br=new BufferedReader(isr); //接水桶
                String str=br.readLine();
                while(str != null){ //官方文件:無值時回傳null
                    System.out.println(str);
                    str=br.readLine(); //回傳下一行給while判斷
                }
            }catch(FileNotFoundException ex){
                System.out.println(ex.getMessage());
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }finally{
                try{
                    fis.close();
                    isr.close();
                    br.close();
                    System.out.println("程式執行完畢");
                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
