package unit32jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

public class YourDB {
    
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
    public void creatTableEMP(Connection conn) throws SQLException{
        //spl 建立資料表之語法 INTEGER+PRIMARY KEY會自動變AUTOINCREMENT(自動增號)
        String sql="CREATE TABLE IF NOT EXISTS employee("
                + "no INTEGER PRIMARY KEY," //同"no INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name STRING,"
                + "dept STRING,"
                + "tel STRING,"
                + "salary DOUBLE,"
                + "gender CHAR(1));";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("employee資料表建立成功~"); 
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
    
    public void creatTableLeave(Connection conn) throws SQLException{
        //spl 建立資料表之語法
        String sql="CREATE TABLE IF NOT EXISTS leave("
                + "no INTEGER NOT NULL,"
                + "date DATE,"
                + "leave STRING,"
                + "hour INTEGER);";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("leave資料表建立成功~"); 
    }
    
    //新增記錄
    public void insertEmp(Connection conn, String name, Dept dept,
            String tel, double salary, Gender gender) throws SQLException{
        
        String sql="INSERT INTO employee(name,dept,tel,salary,gender) VALUES"
                + "(?,?,?,?,?);"; //還不知道資料內容可先用?,先不用加型別會自動判斷
        PreparedStatement ps=conn.prepareStatement(sql); //寫成一行的方式
        int i=1;
        ps.setString(i++, name);
        ps.setString(i++, dept.getDept());
        ps.setString(i++, tel);
        ps.setDouble(i++, salary);
        ps.setInt(i++, gender.getGender()); //char用setInt
        ps.executeUpdate(); //執行上傳
        System.out.println("新增記錄成功~");
    }
    
    //新增請假記錄
    public void insertLeave(Connection conn, int no, String date, Leave leave, int hour) throws SQLException{
        String sql="INSERT INTO leave(no,date,leave,hour) VALUES"
                    + "(?,?,?,?);"; //還不知道資料內容可先用?,先不用加型別會自動判斷
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
                ps.setString(i++, leave.getLeave());
                ps.setInt(i++, hour);
                ps.executeUpdate(); //執行上傳
                flag=true;
                System.out.println("新增請假記錄成功~");
            }
        }
        if(!flag){
                System.out.println("無此員工編號,請假記錄登錄失敗~");
            }
    }
    
    //查詢employee所有員工資料
    public void queryEmp(Connection conn) throws SQLException{
        String sql= "SELECT * FROM employee";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------全體員工資料------");
        while(rs.next()){
            System.out.print(
                    rs.getInt("no") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("dept") + "\t" +
                    rs.getString("tel") + "\t" +
                    rs.getDouble("salary") + "\t" +
                    (char)rs.getInt("gender") + "\n");
        }
        System.out.println("員工資料列示完畢~");
    }
    
    //查詢leave所有請假記錄
    public void queryLeave(Connection conn) throws SQLException{
        String sql= "SELECT * FROM leave";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------全體員工請假資料------");
        while(rs.next()){
            System.out.print(
                    rs.getInt("no") + "\t" +
                    rs.getString("date") + "\t" +
                    rs.getString("leave") + "\t" +
                    rs.getInt("hour") + "\n");
        }
        System.out.println("請假資料列示完畢~");
    }

    //查詢employee員工資料,依no
    public void queryEmpNO(Connection conn, int no) throws SQLException{
        String sql= "SELECT * FROM employee WHERE no=" + no + ";";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------員工編號[" + no + "]之員工資料------");
        while(rs.next()){
            System.out.print(
                    rs.getInt("no") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("dept") + "\t" +
                    rs.getString("tel") + "\t" +
                    rs.getDouble("salary") + "\t" +
                    (char)rs.getInt("gender") + "\n");
        }
        System.out.println("員工資料列示完畢~");
    }
    
    //查詢leave請假資料,依no
    public void queryLeaveNo(Connection conn, int no) throws SQLException{
        String sql= "SELECT * FROM leave WHERE no=" + no + ";";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------員工編號[" + no + "]之員工請假資料------");
        while(rs.next()){
            System.out.print(
                    rs.getInt("no") + "\t" +
                    rs.getString("date") + "\t" +
                    rs.getString("leave") + "\t" +
                    rs.getInt("hour") + "\n");
        }
        System.out.println("請假資料列示完畢~");
    }    
    
    //資料表的關聯,employee,leave依no列出,員工編號,姓名,日期,假別,時數,部門
    public void queryEmpLeave(Connection conn) throws SQLException{
        String sql="SELECT employee.no,employee.name,leave.date,leave.leave,leave.hour,employee.dept "
                + "FROM employee,leave WHERE employee.no=leave.no";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------全體員工請假資料------");
        while(rs.next()){
            System.out.print(
                    rs.getInt("no")+"\t"
                    +rs.getString("name")+"\t"
                    +rs.getString("date")+"\t"
                    +rs.getString("leave")+"\t"
                    +rs.getInt("hour")+"\t"
                    +rs.getString("dept")+"\n");
        }
        System.out.println("請假資料列示完畢~");
    }
    
    //資料表的關聯,employee,leave依no列出,連接表格INNER JOIN ON
    public void queryEmpLeaveJoin(Connection conn) throws SQLException{
        String sql="SELECT employee.no,employee.name,leave.date,leave.leave,leave.hour,employee.dept "
                + "FROM employee INNER JOIN leave ON employee.no=leave.no";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------全體員工請假資料------");
        while(rs.next()){
            System.out.print(
                    rs.getInt("no")+"\t"
                    +rs.getString("name")+"\t"
                    +rs.getString("date")+"\t"
                    +rs.getString("leave")+"\t"
                    +rs.getInt("hour")+"\t"
                    +rs.getString("dept")+"\n");
        }
        System.out.println("請假資料列示完畢~");
    }
    
    //資料表的關聯,查詢出左方資料表全部關聯資料,連接表格LEFT JOIN ON
    public void queryEmpLeaveLeftJoin(Connection conn) throws SQLException{
        String sql="SELECT employee.no,employee.name,leave.date,leave.leave,leave.hour,employee.dept "
                + "FROM employee LEFT JOIN leave ON employee.no=leave.no";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------全體員工請假資料------");
        while(rs.next()){
            System.out.print(
                    rs.getInt("no")+"\t"
                    +rs.getString("name")+"\t"
                    +rs.getString("date")+"\t"
                    +rs.getString("leave")+"\t"
                    +rs.getInt("hour")+"\t"
                    +rs.getString("dept")+"\n");
        }
        System.out.println("請假員工資料列示完畢~");
    }
    
    //LEFT JOIN ON 查詢左方資料表,找出未請假員工,資料表使用假名a,b
    public void queryEmpNotLeave(Connection conn) throws SQLException{
        String sql="SELECT a.no,a.name,b.date,b.leave,b.hour,a.dept "
                + "FROM employee a LEFT JOIN leave b ON a.no=b.no";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------全體員工未請假者資料(資料表用別名)------");
        while(rs.next()){
            if(rs.getInt("hour")==0){
                System.out.print(
                        rs.getInt("no")+"\t"
                        +rs.getString("name")+"\t"
                        +rs.getString("date")+"\t"
                        +rs.getString("leave")+"\t"
                        +rs.getInt("hour")+"\t"
                        +rs.getString("dept")+"\n");
            }
        }
        System.out.println("未請假全勤員工資料列示完畢~");
    }
    
    //LEFT JOIN ON 查詢左方資料表,找出未請假員工+$2000,資料表使用假名a,b
    public void queryEmpNotLeaveSalary(Connection conn) throws SQLException{
        String sql="SELECT a.no,a.name,a.salary,a.salary AS 實領薪資,a.dept,b.hour "
                + "FROM employee a LEFT JOIN leave b ON a.no=b.no";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------全體員工未請假+$2000者資料(資料表用別名)------");
        int bonus=2000;
        while(rs.next()){
            if(rs.getInt("hour")==0){
                System.out.print(
                        rs.getInt("no")+"\t"
                        +rs.getString("name")+"\t"
                        +rs.getDouble("salary")+"\t\t"
                        +(rs.getDouble("實領薪資") + bonus + "*") +"\t"
                        +rs.getString("dept")+"\n");
            }else{
                System.out.print(
                        rs.getInt("no")+"\t"
                        +rs.getString("name")+"\t"
                        +rs.getDouble("salary")+"\t\t"
                        +rs.getDouble("實領薪資") +"\t\t"
                        +rs.getString("dept")+"\n");
            }
        }
        System.out.println("未請假全勤+$2000員工資料列示完畢~");
    }
    
    //列出各部門請假總時數
    public void queryDeptLeaveSum(Connection conn) throws SQLException{
        String sql="SELECT a.no,a.dept,SUM(b.hour) AS 總時數 "
                + "FROM employee a,leave b WHERE a.no=b.no GROUP BY a.dept";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------列出各部門請假總時數資料------");
        while(rs.next()){
            System.out.println(rs.getString("dept") + "之員工請假總時數為:" + rs.getInt("總時數"));
        }
        System.out.println("各部門請假總時數資料列示完畢~");
    }    
}

//部門列舉
enum Dept{
    MIS("資訊部"),
    MKG("行銷部"),
    GAF("總務部"),
    GAC("財務部"),
    SAL("業務部"),
    HR("人資部"),
    RD("研發部");

    private String dept; //列舉可以有成員變數
    private Dept(String dept){ //列舉建構子不對外公開
        this.dept=dept;
    }
    
    public String getDept(){
        return this.dept;
    }
}//部門列舉 end
    
//列舉性別
enum Gender{
    M('男'),
    F('女'),
    N('N');
    
    private char gender;
    private Gender(char gender){
        this.gender=gender;
    }
    
    public char getGender(){
        return this.gender;
    }
}//列舉性別 end

//列舉假別
enum Leave{
    PERSONAL("事假"),
    ANNUAL("特休"),
    OFFICAL("公假"),
    MARRIAGE("婚假"),
    FUNERAL("喪假"),
    SICK("病假");
    
    private String leave;
    private Leave(String leave){
        this.leave=leave;
    }
    
    public String getLeave(){
        return this.leave;
    }
}//列舉假別 end

