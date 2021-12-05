package unit32jdbc;

import java.sql.SQLException;
import java.sql.Connection;

public class TestJDBC3 {
    
    public static void main(String[] args) throws SQLException {
        
        HisDB db=new HisDB();
        Connection conn=db.getConn("empDB2.db");
        
        db.creatEmpView(conn);
        db.CreatLeaveView(conn);
        db.CreatDeptEmpCountView(conn);
        db.creatDeptEmpSalarySumView(conn);
        
        db.queryDeptEmpSalarySumView(conn, "由小到大");
        db.queryDeptEmpSalarySumView(conn, "由大到小");
        db.queryDeptEmpSalarySumView(conn, "隨便打");
        
        db.queryDeptEmpCountView(conn, "由小到大");
        db.queryDeptEmpCountView(conn, "由大到小");
        db.queryDeptEmpCountView(conn, "隨便打");
        
        db.creatEmpLeaveView(conn);
        db.creatAllEmpLeaveView(conn);
        
        //新增overtime資料表
        db.creatTableOvertime(conn);
        //新增加班記錄
        /*
        db.insertOvertime(conn, 1, "2020/10/23", 4);
        db.insertOvertime(conn, 1, "2020/10/24", 4);
        db.insertOvertime(conn, 2, "2020/10/24", 6);
        db.insertOvertime(conn, 4, "2020/10/25", 2);
        */
        db.creatEmpOvertimeSumView(conn);
        db.queryAllEmpLeaveOvertime(conn);
        db.querySalaryMonth(conn);
    }
}
