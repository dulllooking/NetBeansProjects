package unit32jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;
import java.text.DecimalFormat;

public class HisDB {
    
    //連線資料庫,有參數
    public Connection getConn(String url) throws SQLException{
        SQLiteConfig config=new SQLiteConfig();
        config.setSharedCache(true);
        SQLiteDataSource sqlds=new SQLiteDataSource(); //設定資料庫的路徑
        sqlds.setUrl("jdbc:sqlite:db/" + url);
        System.out.println(url + " 資料庫連結成功,YES!!");
        return sqlds.getConnection(); //傳回Connection 實體物件
    }
    

    //建立檢視表 VIEW ,資料從employee來不占記憶體空間
    public void creatEmpView(Connection conn) throws SQLException{
        String sql="CREATE VIEW IF NOT EXISTS empInfo AS SELECT * FROM employee;"; //*全部欄位
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("empInfo 員工檢視表建立完成~"); 
    }
    
    public void CreatLeaveView(Connection conn) throws SQLException{
        String sql="CREATE VIEW IF NOT EXISTS leaveInfo AS SELECT * FROM leave;"; //*全部欄位
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("leaveInfo 員工請假資料檢視表建立完成~");
    }
    
    public void CreatDeptEmpCountView(Connection conn) throws SQLException{
        String sql="CREATE VIEW IF NOT EXISTS 各部門員工人數 AS SELECT dept AS 部門名稱,"
                 + "COUNT(no) AS 員工人數 FROM employee GROUP BY dept;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("各部門員工人數 資料檢視表建立完成~");
    }
    
    public void creatDeptEmpSalarySumView(Connection conn) throws SQLException{
        String sql="CREATE VIEW IF NOT EXISTS 各部門薪資總額 AS SELECT dept AS 部門名稱,"
                 + "SUM(salary) AS 薪資總額 FROM employee GROUP BY dept;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("各部門薪資總額 資料檢視表建立完成~");
    }
    
    //透過檢視表進行資料查詢--各部門員工薪資總額
    public void queryDeptEmpSalarySumView(Connection conn, String order) throws SQLException{
        String sql="";
        if(order.equals("由小到大"))
            sql="SELECT * FROM 各部門薪資總額 ORDER BY 薪資總額 ASC;";
        else if(order.equals("由大到小"))
            sql="SELECT * FROM 各部門薪資總額 ORDER BY 薪資總額 DESC;";
        else
            sql="SELECT * FROM 各部門薪資總額;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        System.out.println("\n各部門員工薪資總額以[" + order + "]來排序~");
        while(rs.next()){
            System.out.print(rs.getString("部門名稱") + "\t"
                            + rs.getDouble("薪資總額") + "\n");
        }
        System.out.println("各部門員工薪資總額資料查詢完畢");
    }
    
    
    //透過檢視表進行資料查詢--各部門員工人數
    public void queryDeptEmpCountView(Connection conn, String order) throws SQLException{
        String sql="";
        if(order.equals("由小到大"))
            sql="SELECT * FROM 各部門員工人數 ORDER BY 員工人數 ASC;";
        else if(order.equals("由大到小"))
            sql="SELECT * FROM 各部門員工人數 ORDER BY 員工人數 DESC;";
        else
            sql="SELECT * FROM 各部門員工人數;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        System.out.println("\n各部門員工人數以[" + order + "]來排序~");
        while(rs.next()){
            System.out.print(rs.getString("部門名稱") + "\t"
                            + rs.getInt("員工人數") + "\n");
        }
        System.out.println("各部門員工薪資總額資料查詢完畢");
    }
    
    //建立員工請假記錄檢視表
    public void creatEmpLeaveView(Connection conn) throws SQLException{
        String sql="CREATE VIEW IF NOT EXISTS empLeaveInfo AS SELECT "
                + "employee.no AS 員工編號,"
                + "employee.name AS 員工姓名,"
                + "leave.date AS 請假日期,"
                + "leave.leave AS 請假類別,"
                + "leave.hour AS 請假時數,"
                + "employee.dept AS 部門名稱 "
                 + "FROM employee,leave WHERE employee.no=leave.no;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("empLeaveInfo 資料檢視表建立完成~");
    }

    //建立所有員工請假記錄檢視表
    public void creatAllEmpLeaveView(Connection conn) throws SQLException{
        String sql="CREATE VIEW IF NOT EXISTS allEmpLeaveInfo AS SELECT "
                + "employee.no AS 員工編號,"
                + "employee.name AS 員工姓名,"
                + "leave.date AS 請假日期,"
                + "leave.leave AS 請假類別,"
                + "leave.hour AS 請假時數,"
                + "employee.salary AS 員工薪資,"
                + "employee.dept AS 部門名稱 "
                + "FROM employee LEFT JOIN leave ON employee.no=leave.no;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("allEmpLeaveInfo 資料檢視表建立完成~");
    }

    //建立加班資料表,連外鍵
    public void creatTableOvertime(Connection conn) throws SQLException{
        String sql="CREATE TABLE IF NOT EXISTS overtime("
                + "no INTEGER REFERENCES employee(no),"
                + "date DATE,"
                + "hour INTEGER);";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("overtime資料表建立成功~"); 
    }
    
    //新增加班記錄
    public void insertOvertime(Connection conn, int no, String date, int hour) throws SQLException{
        String sql="INSERT INTO overtime(no,date,hour) VALUES"
                    + "(?,?,?);"; //還不知道資料內容可先用?,先不用加型別會自動判斷
        PreparedStatement ps=conn.prepareStatement(sql); //寫成一行的方式
        String empsql="SELECT no FROM employee";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(empsql);
        boolean flag=false;
        while(rs.next()){
            if(rs.getInt(1)==no){
                int i=1;
                ps.setInt(i++, no);
                ps.setString(i++, date);
                ps.setInt(i++, hour);
                ps.executeUpdate(); //執行上傳
                flag=true;
                System.out.println("新增加班記錄成功~");
            }
        }
        if(!flag){
                System.out.println("無此員工編號,加班記錄登錄失敗~");
            }
    }
    
    //員工加班總時數檢視表
    public void creatEmpOvertimeSumView(Connection conn) throws SQLException{
        String sql="CREATE VIEW IF NOT EXISTS 員工加班總時數 AS SELECT no AS 員工編號,"
                 + "SUM(hour) AS 加班總數 FROM overtime GROUP BY no;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("員工加班總時數 資料檢視表建立完成~");
    }
    
    //查詢所有員工之請假,加班記錄
    public void queryAllEmpLeaveOvertime(Connection conn) throws SQLException{
         String sql="SELECT v1.員工編號,"
                + "v1.員工姓名,"
                + "SUM(v1.請假時數) AS 請假總數," //有SUM要加GROUP BY
                + "v2.加班總數,"
                + "v1.員工薪資,"
                + "v1.部門名稱 "
                + "FROM allEmpLeaveInfo v1 LEFT JOIN 員工加班總時數 v2 ON v1.員工編號=v2.員工編號"
                + " GROUP BY v1.員工編號;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        System.out.println("-------所有員工的請假與加班記錄------");
        while(rs.next()){
            System.out.print(rs.getInt(1) + "\t"
                            + rs.getString(2) + "\t"
                            + rs.getInt(3) + "\t"
                            + rs.getInt(4) + "\t"
                            + rs.getDouble(5) + "\t"
                            + rs.getString(6) + "\n");
        }
        System.out.println("allEmpLeaveOvertimeInfo 資料查詢完畢~");
    }
    
    //求本月員工薪資
    public void querySalaryMonth(Connection conn) throws SQLException{
         String sql="SELECT v1.員工編號 AS 員工編號,"
                + "v1.員工姓名 AS 員工姓名,"
                + "SUM(v1.請假時數) AS 請假總數," //有SUM要加GROUP BY
                + "v2.加班總數 AS 加班總數,"
                + "v1.員工薪資 AS 員工底薪,"
                + "v1.部門名稱 AS 部門名稱 "
                + "FROM allEmpLeaveInfo v1 LEFT JOIN 員工加班總時數 v2 ON v1.員工編號=v2.員工編號"
                + " GROUP BY v1.員工編號;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        System.out.println("-------本月員工薪資表------");
        int workday=20; //每月工作天數
        int dayhour=8; //每日工作時數
        DecimalFormat df=new DecimalFormat("####,##0");
        Double hourSalary=0.0;
        Double overtimeSalary=0.0;
        Double reduceSalary=0.0;
        Double realSalary=0.0;
        Double realgetSalary=0.0; //實領薪資
        Double bonus=0.0;
        while(rs.next()){
            hourSalary=rs.getDouble("員工底薪")/workday/dayhour; //時薪
            overtimeSalary=rs.getInt("加班總數")*hourSalary*1.67; //加班加給
            reduceSalary=rs.getInt("請假總數")*hourSalary*0.95; //請假扣薪
            realSalary=rs.getDouble("員工底薪")-reduceSalary+overtimeSalary; //結算薪資
            if(rs.getInt("請假總數") == 0)
                bonus=2000.0;
                realgetSalary=realSalary+bonus; //全勤加給
            System.out.print(rs.getInt("員工編號") + "\t"
                            + rs.getString("員工姓名") + "\t"
                            + df.format(rs.getDouble("員工底薪")) + "\t"
                            + df.format(reduceSalary*-1) + "\t"
                            + df.format(overtimeSalary) + "\t"
                            + df.format(bonus) + "\t"
                            + df.format(realgetSalary) + "\t"
                            + rs.getString("部門名稱") + "\n");
            bonus=0.0;
        }
        System.out.println("本月員工薪資 查詢完畢~");
    }
}
