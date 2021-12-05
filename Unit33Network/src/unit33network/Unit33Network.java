package unit33network;

//官方文件InetAddress
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Unit33Network {

    public static void main(String[] args) {
        try{ //InetAddress為static可直接調用
            InetAddress addr=InetAddress.getByName("www.bsnet.com.tw"); //依主機名稱取得IP位址
            InetAddress local=InetAddress.getLocalHost(); //取得本地端IP位址
            InetAddress[] allAddr=InetAddress.getAllByName("DESKTOP-QIIF9VP"); //依主機名稱,取得系統配置服務IP位址陣列
            
            System.out.println(addr);
            System.out.println(local);
            for(int i=0; i<allAddr.length; i++){
                System.out.println(allAddr[i]);
           }
        }catch(UnknownHostException ex){
            System.out.println(ex.getMessage());
        }
        
        //列舉NetworkInterface類別,獲得本機的所有網路接口
        Enumeration<NetworkInterface> nif;
        try{
            nif=NetworkInterface.getNetworkInterfaces();
            while(nif.hasMoreElements()){
                NetworkInterface n=nif.nextElement();
                System.out.println("介面名稱:" + n.getName());
                System.out.println("是否啟動:" + n.isUp());
            }
        }catch(SocketException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
