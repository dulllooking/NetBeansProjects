package unit25io;
import java.io.*;

//Listed File
public class FileList {
    public static void main(String[] args) {
        
        File file=new File("."); //"."表示目前根目錄
        int count=0, dir=0, f=0;
        
        //for each
        for(String e:file.list()){ //傳回以檔案或目錄名稱為元素的字串陣列
            System.out.println(e);
            count++;
            
            File temp=new File(e);
            if(temp.isDirectory()) dir++;
            if(temp.isFile()) f++;
        }
        System.out.println("檔案與目錄總數:" + count);
        System.out.println("目錄總數:" + dir);
        System.out.println("檔案總數:" + f);
    }
}
