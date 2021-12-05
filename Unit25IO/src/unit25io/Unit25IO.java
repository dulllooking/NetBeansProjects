package unit25io;
import java.io.*;

public class Unit25IO {

    //檔案的輸入與輸出 File Input/File Output
    public static void main(String[] args) {
        
        File file=new File("simple.txt");
        if(file.exists())
            System.out.println("simple.txt 檔已建立!!");
        else{
            try{
            if(file.createNewFile()) //提示文件需包在try{}catch{}中
                System.out.println("simple.txt 建立!!");
            }catch(IOException ex){ //查creatNewFile官方文件
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("絕對路徑:" + file.getAbsolutePath());
        System.out.println("路徑:" + file.getPath());
    }
}
