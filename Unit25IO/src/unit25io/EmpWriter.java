package unit25io;
import java.io.*;

public class EmpWriter {
    public static void main(String[] args) throws IOException{
        Employee emp[]={
            new Employee(1,"愛台晚","資訊部",12345.11),
            new Employee(2,"林先生","企劃部",2345.12),
            new Employee(3,"鎮小姐","行銷部",1245.13),
            new Employee(4,"裝聲聲","業務部",345.14),
            new Employee(5,"猜明亮","會計部",5345.15),
        };
        String str="";
        File file=new File("empInfo.txt");
        if(file.exists()){ //找水源
            FileOutputStream fos=new FileOutputStream(file); //接水管
            OutputStreamWriter osw=new OutputStreamWriter(fos); //裝馬達
            BufferedWriter bw=new BufferedWriter(osw); //裝水桶
            
            for(Employee e:emp){
                str=e.getEmpInfo();
                bw.write(str); //寫入,倒入水槽
                bw.flush(); //清空緩衝區
            }
            System.out.println("資料寫入完畢");
            bw.close(); //拿走水桶
            osw.close(); //關馬達
            fos.close(); //抽水管
        }
        
    }
}
