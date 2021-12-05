package unit25io;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFos {
    
    //File output 以位元組方式寫入檔案
    public static void main(String[] args) throws IOException{ //IOException包含FileNotFoundException
        
        String slogan="科技始終來自於人性!!\n";
        byte[] data=slogan.getBytes(); //取得字串的位元組陣列給.write使用
        
        FileOutputStream fos=null;
        fos=new FileOutputStream("simple.txt",true); //一定要有FileNotFoundException,可寫在main裡throws
        //FileOutputStream("simple.txt",true),true表示寫入資料時會附加在原資料後方
        
        //FileOutputStream官方文件write需接收byte
        fos.write(data); //一定要有IOException可寫在main
        System.out.println(slogan + "寫入成功");
        
        fos.close(); //一定要有IOException可寫在main
        
    }
}
