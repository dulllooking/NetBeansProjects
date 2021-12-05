package unit25io;
import java.io.*;

public class MyFOB {
    
    public static void main(String[] args){
        
        String ptt="2020最夯的程式語言?\n";
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        
        try{
            fos=new FileOutputStream("ptt.txt",true);
            osw=new OutputStreamWriter(fos);
            bw=new BufferedWriter(osw);
            try{
                bw.write(ptt);
                bw.flush();
                System.out.println("寫入OK!");
            }catch(IOException e){
                System.out.println("inner...try...catch");
                System.out.println(e.getMessage());
            }
        }catch(FileNotFoundException e){
            System.out.println("Outer...try...catch");
            System.out.println(e.getMessage());
        }finally{
            try{
                bw.close();
                osw.close();
                fos.close();
                System.out.println("關閉OK!");
            }catch(IOException e){
                System.out.println("finally...try...catch");
                System.out.println(e.getMessage());
            }
        }
    }    
}
