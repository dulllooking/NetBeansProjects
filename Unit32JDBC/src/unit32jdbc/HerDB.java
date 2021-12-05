package unit32jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

public class HerDB {
    
    //連線資料庫,有參數
    public Connection getConn(String url) throws SQLException{
        SQLiteConfig config=new SQLiteConfig();
        config.setSharedCache(true);
        SQLiteDataSource sqlds=new SQLiteDataSource(); //設定資料庫的路徑
        sqlds.setUrl("jdbc:sqlite:db/" + url);
        System.out.println(url + " 資料庫連結成功,YES!!");
        return sqlds.getConnection(); //傳回Connection 實體物件
    }
    
    //建立供應商資料表
    public void createTableSupplier(Connection conn) throws SQLException{
        String sql="CREATE TABLE IF NOT EXISTS supplier("
                + "no INTEGER PRIMARY KEY,"
                + "name STRING,"
                + "contact STRING);";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("supplier資料表建立成功~");
    }
    
    //建立產品明細資料表
    public void createTableProduct(Connection conn) throws SQLException{
        String sql="CREATE TABLE IF NOT EXISTS product("
                + "no INTEGER PRIMARY KEY,"
                + "name STRING,"
                + "cost DOUBLE,"
                + "supplierNo INTEGER REFERENCES supplier(no) ON DELETE CASCADE ON UPDATE CASCADE);";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("product資料表建立成功~");
    }
    
    //建立顧客資料表
    public void createTableCustomer(Connection conn) throws SQLException{
        String sql="CREATE TABLE IF NOT EXISTS customer("
                + "no INTEGER PRIMARY KEY,"
                + "name STRING,"
                + "contact STRING);";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("customer資料表建立成功~");
    }
    
    //建立訂單明細表
    public void createTableOrderDetail(Connection conn) throws SQLException{
        String sql="CREATE TABLE IF NOT EXISTS orderDetail("
                + "id INTEGER PRIMARY KEY,"
                + "productNo INTEGER REFERENCES product(no),"
                + "date DATE,"
                + "price DOUBLE,"
                + "quantity INTEGER,"
                + "saleNo INTEGER REFERENCES employee(no),"
                + "customerNo INTEGER REFERENCES customer(no));";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("orderDetail資料表建立成功~");
    }
    
    //新增供應商記錄
    public void insertSupplier(Connection conn, String name, String contact) throws SQLException{
        String sql="INSERT INTO supplier(name,contact) VALUES"
                + "(?,?);"; //還不知道資料內容可先用?,先不用加型別會自動判斷
        PreparedStatement ps=conn.prepareStatement(sql); //寫成一行的方式
        int i=1;
        ps.setString(i++, name);
        ps.setString(i++, contact);
        ps.executeUpdate(); //執行上傳
        System.out.println("新增supplier記錄成功~");
    }
    
    //新增產品記錄
    public void insertProduct(Connection conn, String name, double cost, int supplierNo) throws SQLException{
        String sql="INSERT INTO product(name,cost,supplierNo) VALUES"
                    + "(?,?,?);"; //還不知道資料內容可先用?,先不用加型別會自動判斷
        PreparedStatement ps=conn.prepareStatement(sql); //寫成一行的方式
        String supSql="SELECT no FROM supplier";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(supSql);
        boolean flag=false;
        while(rs.next()){
            if(rs.getInt(1)==supplierNo){
                int i=1;
                ps.setString(i++, name);
                ps.setDouble(i++, cost);
                ps.setInt(i++, supplierNo);
                ps.executeUpdate(); //執行上傳
                flag=true;
                System.out.println("新增product記錄成功~");
            }
        }
        if(!flag){
                System.out.println("無此供應商編號,記錄登錄失敗~");
            }
    }
    
    //新增顧客資料
    public void insertCustomer(Connection conn, String name, String contact) throws SQLException{
        String sql="INSERT INTO customer(name,contact) VALUES"
                + "(?,?);"; //還不知道資料內容可先用?,先不用加型別會自動判斷
        PreparedStatement ps=conn.prepareStatement(sql); //寫成一行的方式
        int i=1;
        ps.setString(i++, name);
        ps.setString(i++, contact);
        ps.executeUpdate(); //執行上傳
        System.out.println("新增customer記錄成功~");
    }
    
    //新增訂單資料
    public void insertOrderDetail(Connection conn,
            int productNo,
            String date,
            double price,
            int quantity,
            int saleNo,
            int customerNo) throws SQLException{
        String sql="INSERT INTO orderDetail(productNo,date,price,quantity,saleNo,customerNo) VALUES"
                    + "(?,?,?,?,?,?);"; //還不知道資料內容可先用?,先不用加型別會自動判斷
        PreparedStatement ps=conn.prepareStatement(sql); //寫成一行的方式
        String proSql="SELECT no FROM product";
        String empSql="SELECT no FROM employee"; //業務員
        String cusSql="SELECT no FROM customer";
        Statement st=conn.createStatement();
        ResultSet rs=null;
        boolean proFlag=false;
        boolean empFlag=false;
        boolean cusFlag=false;
        
        rs=st.executeQuery(proSql); //查詢結果
        while(rs.next()){
            if(rs.getInt(1)==productNo){
                proFlag=true;
                break;
            }
        }
        rs=st.executeQuery(empSql); //查詢結果
        while(rs.next()){
            if(rs.getInt(1)==saleNo){
                empFlag=true;
                break;
            }
        }
        rs=st.executeQuery(cusSql); //查詢結果
        while(rs.next()){
            if(rs.getInt(1)==customerNo){
                cusFlag=true;
                break;
            }
        }
        //判斷式
        if(proFlag && empFlag && cusFlag){
            int i=1;
            ps.setInt(i++, productNo);
            ps.setString(i++, date);
            ps.setDouble(i++, price);
            ps.setInt(i++, quantity);
            ps.setInt(i++, saleNo);
            ps.setInt(i++, customerNo);
            ps.executeUpdate(); //執行上傳
            System.out.println("新增orderDetail記錄成功~");
        }
        if(!proFlag)System.out.println("無此商品編號,記錄登錄失敗~");
        if(!empFlag)System.out.println("無此業務編號,記錄登錄失敗~");
        if(!cusFlag)System.out.println("無此顧客編號,記錄登錄失敗~");
    }
    
    //查詢訂單明細,產品,顧客
    public void queryOrderDetailProCus(Connection conn) throws SQLException{
        String sql="SELECT p.no AS 產品編號,"
                + "p.name AS 產品名稱,"
                + "p.cost AS 成本,"
                + "o.price AS 價格,"
                + "o.quantity AS 數量,"
                + "c.name AS 顧客名稱 "
                + "FROM ((product AS p INNER JOIN orderDetail AS o ON p.no=o.productNo) "
                + "INNER JOIN customer AS c ON c.no=o.customerNo);";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------訂單明細 產品與顧客資料列表------");
        //取得欄位名稱
        for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
            System.out.print(String.format("%8s", rs.getMetaData().getColumnName(i)) + "\t");
        }
        System.out.println();
        //取得內容資料
        while(rs.next()){
            System.out.print(
                    String.format("%8d", rs.getInt("產品編號")) + "\t"
                    + String.format("%8s", rs.getString("產品名稱")) + "\t"
                    + String.format("%10.1f", rs.getDouble("成本")) + "\t"
                    + String.format("%10.1f", rs.getDouble("價格")) +"\t"
                    + String.format("%8d", rs.getInt("數量")) + "\t"
                    + String.format("%8s", rs.getString("顧客名稱")) + "\n");
        }
        System.out.println("顧客訂單明細資料列示完畢~");
    }
    
    //查詢訂單明細,產品,銷售人員
    public void queryOrderDetailProEmp(Connection conn) throws SQLException{
        String sql="SELECT p.name AS 產品名稱,"
                + "p.cost AS 成本,"
                + "o.price AS 價格,"
                + "o.quantity AS 數量,"
                + "(o.price - p.cost)*o.quantity AS 每筆毛利,"
                + "e.name AS 銷售人員 "
                + "FROM product AS p INNER JOIN orderDetail AS o ON p.no=o.productNo "
                + "INNER JOIN employee AS e ON e.no=o.saleNo;";
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------銷售明細 產品與業務員資料列表------");
        //取得欄位名稱
        for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
            System.out.print(String.format("%8s", rs.getMetaData().getColumnName(i)) + "\t");
        }
        System.out.println();
        double profitTotal=0.0; //銷售毛利總額
        //取得內容資料
        while(rs.next()){
            profitTotal=profitTotal + rs.getDouble("每筆毛利");
            System.out.print(
                    String.format("%8s", rs.getString("產品名稱")) + "\t"
                    + String.format("%10.1f", rs.getDouble("成本")) + "\t"
                    + String.format("%10.1f", rs.getDouble("價格")) +"\t"
                    + String.format("%8d", rs.getInt("數量")) + "\t"
                    + String.format("%10.1f", rs.getDouble("每筆毛利")) + "\t"
                    + String.format("%8s", rs.getString("銷售人員")) + "\n");
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("銷售毛利總額" + String.format("%10.1f",profitTotal));
        System.out.println("=====================================================================");
        System.out.println("業務銷售明細資料列示完畢~");
    }
    
    //查詢訂單明細,產品,銷售人員,供應商,顧客
    public void queryOrderDetailAll(Connection conn) throws SQLException{
        String sql="SELECT o.id AS 訂單編號,"
                + "p.no AS 產品編號,"
                + "p.name AS 產品名稱,"
                + "s.name AS 供應商名稱,"
                + "c.name AS 顧客名稱,"
                + "e.name AS 銷售人員,"
                + "p.cost AS 成本,"
                + "o.price AS 價格,"
                + "o.quantity AS 數量,"
                + "(o.price - p.cost)*o.quantity AS 每筆毛利 "
                + "FROM product AS p INNER JOIN orderDetail AS o ON p.no=o.productNo "
                + "INNER JOIN supplier AS s ON s.no=p.supplierNo "
                + "INNER JOIN customer AS c ON c.no=o.customerNo "
                + "INNER JOIN employee AS e ON e.no=o.saleNo;";
                
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery(sql); //ResultSet結果=查詢
        System.out.println("\n------訂單明細 產品與業務員資料列表------");
        //取得欄位名稱
        for(int i=1; i<=rs.getMetaData().getColumnCount(); i++){
            System.out.print(String.format("%8s", rs.getMetaData().getColumnName(i)) + "\t");
        }
        System.out.println();
        double profitTotal=0.0; //銷售毛利總額
        //取得內容資料
        while(rs.next()){
            profitTotal=profitTotal + rs.getDouble("每筆毛利");
            System.out.print(
                    String.format("%8d", rs.getInt(1)) + "\t"
                    + String.format("%8d", rs.getInt(2)) + "\t"
                    + String.format("%8s", rs.getString(3)) + "\t"
                    + String.format("%8s", rs.getString(4)) +"\t"
                    + String.format("%8s", rs.getString(5)) + "\t"
                    + String.format("%8s", rs.getString(6)) + "\t"
                    + String.format("%10.1f", rs.getDouble(7)) + "\t"
                    + String.format("%10.1f", rs.getDouble(8)) + "\t"
                    + String.format("%8d", rs.getInt(9)) + "\t"
                    + String.format("%10.1f", rs.getDouble(10)) + "\n");
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("銷售毛利總額" + String.format("%10.1f",profitTotal));
        System.out.println("=====================================================================");
        System.out.println("業務銷售明細資料列示完畢~");
    }
    
    //建立訂單明細檢視表
    public void creatOrderDetailAllView(Connection conn) throws SQLException{
        String sql="CREATE VIEW IF NOT EXISTS allOrderDetail AS SELECT "
                + "o.id AS 訂單編號,"
                + "p.no AS 產品編號,"
                + "p.name AS 產品名稱,"
                + "s.name AS 供應商名稱,"
                + "c.name AS 顧客名稱,"
                + "e.name AS 銷售人員,"
                + "p.cost AS 成本,"
                + "o.price AS 價格,"
                + "o.quantity AS 數量,"
                + "(o.price - p.cost)*o.quantity AS 每筆毛利 "
                + "FROM product AS p INNER JOIN orderDetail AS o ON p.no=o.productNo "
                + "INNER JOIN supplier AS s ON s.no=p.supplierNo "
                + "INNER JOIN customer AS c ON c.no=o.customerNo "
                + "INNER JOIN employee AS e ON e.no=o.saleNo;";
        Statement st=null; //Statement介面無法new建立實體
        st=conn.createStatement();
        st.executeUpdate(sql);
        System.out.println("allOrderDetail 資料檢視表建立完成~");
    }
}
