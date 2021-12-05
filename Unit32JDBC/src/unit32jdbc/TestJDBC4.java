package unit32jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;
import java.text.DecimalFormat;

public class TestJDBC4 {
    
    public static void main(String[] args) throws SQLException {
        
        HerDB db=new HerDB();
        Connection conn=db.getConn("empDB2.db");
        db.createTableSupplier(conn);
        db.createTableProduct(conn);
        db.createTableCustomer(conn);
        db.createTableOrderDetail(conn);
        
        //新增supplier記錄
        /*
        db.insertSupplier(conn, "達美樂股份有限公司", "8825252");
        db.insertSupplier(conn, "肯德基股份有限公司", "8835757");
        db.insertSupplier(conn, "必勝客股份有限公司", "3939889");
        db.insertSupplier(conn, "麥當勞股份有限公司", "3366993");
        */
        
        //新增product記錄
        /*
        db.insertProduct(conn, "2B", 123.1, 2);
        db.insertProduct(conn, "3C", 125.1, 1);
        db.insertProduct(conn, "2B", 223.1, 2);
        db.insertProduct(conn, "BB", 127.1, 3);
        db.insertProduct(conn, "RR", 223.1, 4);
        //db.insertProduct(conn, "BB", 443.1, 6);
        */
        
        /*
        //新增customer記錄
        db.insertCustomer(conn, "爭有錢", "money@google.com");
        db.insertCustomer(conn, "爭辛苦", "hard@google.com");
        db.insertCustomer(conn, "爭好笑", "funny@google.com");
        */

        /*
        //新增orderDetail記錄
        db.insertOrderDetail(conn, 1, "2020/11/11", 122.1, 1, 1, 3);
        //db.insertOrderDetail(conn, 1, "2020/11/11", 122.1, 1, 1, 4); //無此顧客編號
        db.insertOrderDetail(conn, 5, "2020/11/11", 122.1, 1, 1, 3);
        //db.insertOrderDetail(conn, 6, "2020/11/11", 122.1, 1, 1, 3); //無此商品編號
        db.insertOrderDetail(conn, 1, "2020/11/11", 122.1, 1, 4, 3);
        //db.insertOrderDetail(conn, 1, "2020/11/11", 122.1, 1, 5, 3); //無此業務編號
        db.insertOrderDetail(conn, 2, "2020/11/11", 322.1, 2, 4, 3);
        db.insertOrderDetail(conn, 2, "2020/11/11", 322.1, 2, 4, 2);
        */
        db.queryOrderDetailProCus(conn);
        db.queryOrderDetailProEmp(conn);
        db.queryOrderDetailAll(conn);
        db.creatOrderDetailAllView(conn);
    }
    
}
