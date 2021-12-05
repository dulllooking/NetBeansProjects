package unit32jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

public class MyDB {
    
    //連線資料庫,無參數
    public Connection getConn() throws SQLException{
        SQLiteConfig config=new SQLiteConfig();
        config.setSharedCache(true);
        SQLiteDataSource sqlds=new SQLiteDataSource(); //設定資料庫的路徑
        //sqlds.setUrl("jdbc:sqlite:C:/Users/Dull-T101HA/Documents/NetBeansProjects/Unit32JDBC/db/TEST.db");
        sqlds.setUrl("jdbc:sqlite:db/TEST.db");
        return sqlds.getConnection(); //傳回Connection 實體物件
    }
    
    //連線資料庫,有參數
    public Connection getConn(String url) throws SQLException{
        SQLiteConfig config=new SQLiteConfig();
        config.setSharedCache(true);
        SQLiteDataSource sqlds=new SQLiteDataSource(); //設定資料庫的路徑
        sqlds.setUrl("jdbc:sqlite:db/" + url);
        System.out.println(url + " 資料庫連結成功,YES!!");
        return sqlds.getConnection(); //傳回Connection 實體物件
    }
    
    //建立資料表,有一參數用來連結資料庫
    public void creatTable(Connection conn) throws SQLException{
        //spl 建立資料表之語法
        String sql="CREATE TABLE IF NOT EXISTS employee("
                + "no INTEGER,"
                + "name STRING,"
                + "dept STRING,"
                + "tel STRING,"
                + "salary DOUBLE);";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        //如果沒加IF NOT EXISTS,第二次執行時不會印出,因為已建立,會報Exception說檔案已建立
        System.out.println("資料表建立成功~"); 
    }
    
    //建立資料表,有2參數用來連結資料庫,及建立資料表
    public void creatTable(Connection conn, String table) throws SQLException{
        //EXISTS後方要有空格,不然會執行會報錯(near "EXISTSLeave": syntax error)
        String sql="CREATE TABLE IF NOT EXISTS " + table;
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql); //執行上傳
        System.out.println("資料表建立成功~!!");
    }
    
    //刪除資料表,有一參數用來連結資料庫
    public void dropTable(Connection conn) throws SQLException{
        String sql="DROP TABLE IF EXISTS employee";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql); //執行上傳
        System.out.println("資料表刪除成功~");
    }
    
    //刪除資料表,有2參數用來連結資料庫,及刪除資料表
    public void dropTable(Connection conn, String table) throws SQLException{
        String sql="DROP TABLE IF EXISTS " + table + ";";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql); //執行上傳
        System.out.println("資料表刪除成功~!!");
    }
    
    //修改資料表,新增欄位
    public void alterTable(Connection conn) throws SQLException{
        String sql="ALTER TABLE employee ADD gender CHAR(1);";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql); //執行上傳
        System.out.println("資料表修改成功~");
    }
    
    //輸入資料,插入資料
    public void insertEmp(Connection conn, int no, String name, String dept,
            String tel, double salary, char gender) throws SQLException{
        
        String sql="INSERT INTO employee(no,name,dept,tel,salary,gender) VALUES"
                + "(?,?,?,?,?,?);"; //還不知道資料內容可先用?,先不用加型別會自動判斷
        PreparedStatement ps=conn.prepareStatement(sql); //寫成一行的方式
        int i=1;
        ps.setInt(i++, no);
        ps.setString(i++, name);
        ps.setString(i++, dept);
        ps.setString(i++, tel);
        ps.setDouble(i++, salary);
        ps.setInt(i++, gender); //char用setInt
        ps.executeUpdate(); //執行上傳
        System.out.println("新增資料成功~");
    }
    
    //查詢資料表的紀錄
    public void queryEmp(Connection conn) throws SQLException{
        String sql= "SELECT * FROM employee";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        while(rs.next()){
            System.out.print(
                    rs.getInt("no") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("dept") + "\t" +
                    rs.getString("tel") + "\t" +
                    rs.getDouble("salary") + "\t" +
                    (char)rs.getInt("gender") + "\n");
        }
        System.out.println("資料列示完畢~");
    }
    
    //自訂SQL查詢語法
    public void queryEmp(Connection conn, String sql) throws SQLException{
        //String sql= "SELECT * FROM employee";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        while(rs.next()){
            System.out.print(
                    rs.getInt("no") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("dept") + "\t" +
                    rs.getString("tel") + "\t" +
                    rs.getDouble("salary") + "\t" +
                    (char)rs.getInt("gender") + "\n");
        }
        System.out.println("資料列示完畢~");
    }
    
    //查詢計算SQL函數的應用,員工總數
    public void queryEmpCount(Connection conn, String sql) throws SQLException{
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        while(rs.next()){
            System.out.println("員工總人數:" + rs.getInt("員工總人數") + "人\n");
        }
        System.out.println("資料處理完畢~");
    }
    //員工總數,增加修改彈性作法
    public void queryEmpCount(Connection conn, String sql, String colName) throws SQLException{
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        while(rs.next()){
            System.out.println("員工總人數:" + rs.getInt(colName) + "人\n");
        }
        System.out.println("資料處理完畢~");
    }
    
    //薪資總額,SUM
    public void queryEmpSalarySum(Connection conn, String sql) throws SQLException{
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        while(rs.next()){
            System.out.println("薪資總額:" + rs.getFloat("薪資總額") + "元\n");
        }
        System.out.println("資料處理完畢~");
    }
    //薪資總額,SUM,增加修改彈性作法
    public void queryEmpSalarySum(Connection conn, String sql,String colName) throws SQLException{
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        while(rs.next()){
            System.out.println("薪資總額:" + rs.getFloat(colName) + "元\n");
        }
        System.out.println("資料處理完畢~");
    }    
    //GROUP BY,每個部門員工人數
    public void queryEmpDeptCount(Connection conn) throws SQLException{
        String sql="SELECT dept AS 部門名稱, COUNT(no) AS 部門員工總數 FROM employee GROUP BY dept";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("部門名稱\t\t部門員工總數");
        while(rs.next()){
            System.out.print(rs.getString("部門名稱") + "\t");
            System.out.print(rs.getString("部門員工總數") + "\n");
        }
        System.out.println("資料處理完畢~\n");
    }
    //某個部門員工總數,GROUP BY //HAVING是條件子句接在GROUP BY後面,LIKE接在HANING後模糊條件用%%定義
    public void queryEmpDeptCount(Connection conn, String dept) throws SQLException{
        String sql="SELECT dept AS 部門名稱, COUNT(no) AS 部門員工總數 FROM employee GROUP BY dept "
                + "HAVING dept LIKE '" + dept + "';"; //'dept'拉出來變參數,要記得打''
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("部門名稱\t\t部門員工總數");
        while(rs.next()){
            System.out.print(rs.getString("部門名稱") + "\t");
            System.out.print(rs.getString("部門員工總數") + "\n");
        }
        System.out.println("資料處理完畢~\n");
    }
    
    //每個部門薪資總額,SUM
    public void queryEmpDeptSalarySum(Connection conn) throws SQLException{
        String sql="SELECT dept AS 部門名稱, SUM(salary) AS 部門薪資總額 FROM employee GROUP BY dept";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("部門名稱\t\t部門薪資總額");
        while(rs.next()){
            System.out.print(rs.getString("部門名稱") + "\t");
            System.out.print(rs.getString("部門薪資總額") + "\n");
        }
        System.out.println("資料處理完畢~\n");
    }
    //某個部門薪資總額,SUM
    public void queryEmpDeptSalarySum(Connection conn, String dept) throws SQLException{
        String sql="SELECT dept AS 部門名稱, SUM(salary) AS 部門薪資總額 FROM employee GROUP BY dept "
                + "HAVING dept LIKE '" + dept + "';"; //'dept'拉出來變參數,要記得打''
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("部門名稱\t\t部門薪資總額");
        while(rs.next()){
            System.out.print(rs.getString("部門名稱") + "\t");
            System.out.print(rs.getString("部門薪資總額") + "\n");
        }
        System.out.println("資料處理完畢~\n");
    }

    //查詢員工資料(含欄位資料)
    public void queryEmpColName(Connection conn) throws SQLException{
        String sql="SELECT no AS 員工編號, "
                + "name AS 員工姓名, "
                + "dept AS 部門名稱, "
                + "tel AS 連絡電話, "
                + "salary AS 員工底薪, "
                + "gender AS 員工性別 FROM employee;";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){ //上面i也是從1開始
            //System.out.print(rs.getMetaData().getColumnLabel(i) + "\t"); //OK
            if(i<3) System.out.print(rs.getMetaData().getColumnLabel(i) + "\t");
            else System.out.print(rs.getMetaData().getColumnName(i) + "\t\t");
        }
        System.out.println();
        while(rs.next()){
            System.out.print(
                    rs.getInt("員工編號") + "\t" +
                    rs.getString("員工姓名") + "\t" +
                    rs.getString("部門名稱") + "\t" +
                    rs.getString("連絡電話") + "\t" +
                    rs.getDouble("員工底薪") + "\t\t" +
                    (char)rs.getInt("員工性別") + "\n");
        }
        /*
        while(rs.next()){
            System.out.print(
                    rs.getInt(1) + "\t" +
                    rs.getString(2) + "\t" +
                    rs.getString(3) + "\t" +
                    rs.getString(4) + "\t" +
                    rs.getDouble(5) + "\t\t" +
                    (char)rs.getInt(6) + "\n");
        } //結果相同
        */
        System.out.println("~記錄列示完畢~");
    }
    
    //UPDATE 修改資料
    public void updateEmp(Connection conn, int no, String newName, double newSalary) throws SQLException{
        String sql="UPDATE employee SET name=?,salary=? WHERE no=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        int i=1;
        ps.setString(i++, newName);
        ps.setDouble(i++, newSalary);
        ps.setInt(i++, no);
        ps.executeUpdate();
        System.out.println("修改紀錄完成!!");
    }
    
    //刪除資料 DELETE
    public void deleteEmp(Connection conn, int no) throws SQLException{
        String sql="DELETE FROM employee WHERE no=?";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1, no);
        ps.executeUpdate();
        System.out.println("刪除紀錄完成!!");
    }
}
