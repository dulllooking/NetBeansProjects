package unit32jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBC {

    public static void main(String[] args) throws SQLException {
    
        MyDB mydb=new MyDB();
        Connection conn=mydb.getConn("EmpDB.db");
        /*
        mydb.creatTable(conn);
        mydb.insertEmp(conn, 3, "john", "Marketing", "123456789", 599.32, 'm');
        mydb.insertEmp(conn, 4, "joe", "Marketing", "222456789", 545.32, 'm');
        mydb.insertEmp(conn, 5, "amy", "Producte", "566666789", 399.32, 'f');
        mydb.insertEmp(conn, 6, "mike", "SaleSale", "999456789", 769.32, 'm');
        mydb.insertEmp(conn, 7, "dell", "Mismismis", "777776789", 349.32, 'm');
        */
        
        //查詢資料表的紀錄
        mydb.queryEmp(conn);
        
        System.out.println("\n~~~~~~自訂SQL查詢語法~~~~~~");
        String sql="";
        sql="SELECT * FROM employee";
        mydb.queryEmp(conn, sql);
        
        System.out.println("\n~~~~~~條件子句查詢語法 WHERE LIKE~~~~~~");
        sql="SELECT * FROM employee WHERE dept LIKE 'SaleSale'";
        mydb.queryEmp(conn, sql);
        
        System.out.println("\n~~~~~~條件子句查詢語法 WHERE >=~~~~~~");
        sql="SELECT * FROM employee WHERE salary >= 600";
        mydb.queryEmp(conn, sql);
        
        System.out.println("\n~~~~~~條件子句查詢語法 WHERE =~~~~~~");
        sql="SELECT * FROM employee WHERE gender=102";
        mydb.queryEmp(conn, sql);
        
        System.out.println("\n~~~~~~條件子句查詢語法 WHERE LIKE AND~~~~~~");
        sql="SELECT * FROM employee WHERE dept LIKE 'Marketing' AND gender=109";
        mydb.queryEmp(conn, sql);
        
        System.out.println("\n~~~~~~條件子句查詢語法 WHERE LIKE OR~~~~~~");
        sql="SELECT * FROM employee WHERE dept LIKE 'SaleSale' OR gender=102";
        mydb.queryEmp(conn, sql);
        
        System.out.println("\n~~~~~~條件子句查詢語法 WHERE BETWEEN AND~~~~~~");
        sql="SELECT * FROM employee WHERE salary BETWEEN 300 AND 550";
        mydb.queryEmp(conn, sql);
        
        System.out.println("\n~~~~~~條件子句查詢語法 WHERE IN~~~~~~");
        sql="SELECT * FROM employee WHERE dept IN('SaleSale', 'Mismismis')";
        mydb.queryEmp(conn, sql);
        
        System.out.println("\n~~~~~~查詢計算SQL函數的應用~~~~~~");
        sql="SELECT COUNT(no) AS 員工總人數 FROM employee;";
        mydb.queryEmpCount(conn, sql);
        
        System.out.println("\n~~~~~~查詢計算SQL函數的應用彈性作法~~~~~~");
        String colName="";
        colName="總人數";
        sql="SELECT COUNT(no) AS " + colName + " FROM employee;";
        mydb.queryEmpCount(conn, sql, colName);
        
        System.out.println("\n~~~~~~薪資計算SQL函數的應用~~~~~~");
        sql="SELECT SUM(salary) AS 薪資總額 FROM employee;";
        mydb.queryEmpSalarySum(conn, sql);
        
        System.out.println("\n~~~~~~薪資計算SQL函數的應用彈性~~~~~~");
        colName="薪資支付總額";
        sql="SELECT SUM(salary) AS " + colName + " FROM employee;";
        mydb.queryEmpSalarySum(conn, sql, colName);
        
        System.out.println("\n~~~~~~SQL函數的應用GROUP BY~~~~~~");
        System.out.println("\n~~~~~~每個部門員工總數~~~~~~");
        mydb.queryEmpDeptCount(conn);
        System.out.println("\n~~~~~~某個部門員工總數~~~~~~");
        mydb.queryEmpDeptCount(conn, "SaleSale");
        mydb.queryEmpDeptCount(conn, "Marketing");
        
        System.out.println("\n~~~~~~SQL函數的應用SUM~~~~~~");
        System.out.println("\n~~~~~~每個部門薪資總額~~~~~~");
        mydb.queryEmpDeptSalarySum(conn);
        System.out.println("\n~~~~~~某個部門薪資總額~~~~~~");
        mydb.queryEmpDeptSalarySum(conn, "SaleSale");
        mydb.queryEmpDeptSalarySum(conn, "Marketing");
        
        System.out.println("\n~~~~~~查詢員工資料(含欄位資料)~~~~~~");
        mydb.queryEmpColName(conn);
        
        System.out.println("\n~~~~~~UPDATE修改amy的name,salary~~~~~~");
        mydb.updateEmp(conn, 5, "艾咪", 450.54);
        System.out.println("\n~~~~~~UPDATE修改後~~~~~~");
        mydb.queryEmpColName(conn);
        
        System.out.println("\n~~~~~~DELETE修改~~~~~~");
        mydb.deleteEmp(conn, 3);
        System.out.println("\n~~~~~~DELETE修改後~~~~~~");
        mydb.queryEmpColName(conn);
    }
}
