package unit25io;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Gossip {
    
    public static void main(String[] args) throws IOException{
        String fileName="gossip.txt"; //八卦檔案
        String gossipDate=""; //記錄八卦留言時間
        String name=""; //留言者
        String content=""; //八卦內容
        String gossipInfo=""; //串接留言時間,留言者,八卦內容
        Scanner scn=new Scanner(System.in);
        
        System.out.print("請輸入您的大名:");
        name=scn.next();
        
        createFile(fileName);
        System.out.println(name + "歡迎來到BSNET GOSSIP SYSTEM");
        System.out.println("========================================");
        while(true){
            System.out.print("請輸入八卦,輸入[quit]則離開,輸入[read]則讀八卦:");
            content=scn.next();
            if(content.equalsIgnoreCase("quit")) break;
            if(content.equalsIgnoreCase("read"))
                readGossip(fileName);
            else{
                gossipDate=getGossipDate();
                gossipInfo=gossipDate + "," + name + "," + content + "\n";
                writeGossip(fileName,gossipInfo);
            }    
        }
        System.out.println("881~");
    } //main end
    
    
    //建立檔案
    public static void createFile(String fileName) throws IOException{
        File file=new File(fileName);
        if(!file.exists() && file.createNewFile())
            System.out.println(fileName + "檔案建立完成!!");
    } //createFile end
    
    
    //讀取八卦訊息檔案
    public static void readGossip(String fileName) throws IOException{
        FileInputStream fis=new FileInputStream(fileName);
        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(isr);
        String str=br.readLine();
        while(str != null){ //官方文件:無值時回傳null
            System.out.println(str);
            str=br.readLine(); //回傳下一行給while判斷
        }
        fis.close();
        isr.close();
        br.close();
    } //readGossip end
    
    
    //寫入八卦訊息至檔案
    public static void writeGossip(String fileName, String gossipInfo) throws IOException{
        FileOutputStream fos=new FileOutputStream(fileName,true);
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        BufferedWriter bw=new BufferedWriter(osw);
        bw.write(gossipInfo);
        bw.flush();
        System.out.println("寫入OK!");
        bw.close();
        osw.close();
        fos.close();
    } //writeGossip end
    
    
    //取得八卦留言時間
    public static String getGossipDate(){
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        return sdf.format(date);
    } //getGossipDate end
}
