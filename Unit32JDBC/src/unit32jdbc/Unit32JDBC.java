package unit32jdbc;
//Libraries>Add JAR/Folder>sqlite-jdbc-3.7.2.jar(載入JDBC連接資料庫API)
//Libraries>Add JAR/Folder>db(載入db資料夾,方便檢查資料庫有無建立)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Unit32JDBC {

    public static void main(String[] args) {
        
        Connection conn=null; //官方文件:Connection是介面,無法直接用new實體
        MyDB mydb=new MyDB();
        try{
            conn=DriverManager.getConnection("jdbc:sqlite:C:/Users/Dull-T101HA/Documents/NetBeansProjects/Unit32JDBC/db/TEST.db");
            //無法連結,需用SQLiteDataSource調用
            System.out.println("資料庫連結成功");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        //連線資料庫,無參數
        try{
            conn=mydb.getConn();
            System.out.println("資料庫連結成功,YES~");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        //連線資料庫,有參數
        try{
            conn=mydb.getConn("Test1.db");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        //連結資料庫與建立資料表
        try{
            //mydb.creatTable(mydb.getConn("EmpDB.db")); //寫成一行
            conn=mydb.getConn("EmpDB.db");
            mydb.creatTable(conn);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        //建立資料表,有2參數用來連結資料庫,及建立資料表
        String table="Leave("
                + "no INTEGER,"
                + "leave STRING,"
                + "date DATE,"
                + "hour INTEGER);";
        try{
            mydb.creatTable(mydb.getConn("EmpDB.db"), table); //寫成一行
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        //刪除資料表,有1參數用來連結資料庫
        try{
            mydb.dropTable(mydb.getConn("EmpDB.db")); //寫成一行
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        //刪除資料表,有2參數用來連結資料庫,及刪除資料表
        String tableName="Leave";
        try{
            mydb.dropTable(mydb.getConn("EmpDB.db"), tableName); //寫成一行
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        //修改資料表,新增欄位
        try{
            mydb.creatTable(mydb.getConn("EmpDB.db")); //建立employee資料表(之前刪掉了先補回來才能修改)
            mydb.alterTable(mydb.getConn("EmpDB.db")); //於employee資料表新增一欄位gender CHAR(1)
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        //輸入資料,插入資料
        try{
            mydb.insertEmp(mydb.getConn("EmpDB.db"), 1, "Amy", "MIS", "12345678", 6543.21, 'm');
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
