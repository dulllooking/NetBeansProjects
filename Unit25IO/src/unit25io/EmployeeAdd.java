package unit25io;
import java.io.IOException;
import java.io.FileOutputStream;
import java.util.Scanner;

//新進員工管理系統
public class EmployeeAdd {
    
    public static void main(String[] args) throws IOException{
        
        Scanner scn=new Scanner(System.in);
        int no=0;
        String name="";
        String dept="";
        double salary=0.0;
        FileOutputStream fos=new FileOutputStream("employee.txt",true);
        
        while(true){
            System.out.println("請輸入:員工編號,姓名,部門,薪水");
            no=scn.nextInt();
            name=scn.next();
            dept=scn.next();
            salary=scn.nextDouble();
            Employee emp=new Employee(no, name, dept, salary);
            byte[] data=(emp.getEmpInfo() + "\r\n").getBytes();
            fos.write(data);
            System.out.println("按[y]或[Y]繼續輸入,按[n]或[N]離開 :");
            if(scn.next().equalsIgnoreCase("n")) break;
        }
        System.out.println("\n--------資料輸入完畢-------");
        fos.close();
    }
} //EmployeeAdd end

