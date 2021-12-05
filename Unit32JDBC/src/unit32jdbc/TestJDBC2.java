package unit32jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestJDBC2 {
    
    public static void main(String[] args) throws SQLException {
    
        YourDB ydb=new YourDB();
        Connection conn=ydb.getConn("empDB2.db");
        //Connection conn=方便下面使用
        ydb.creatTableEMP(conn);
        ydb.creatTableLeave(conn);
        
        /*
        //新增記錄
        ydb.insertEmp(conn, "科及爸", Dept.RD, "333456789", 55505, Gender.M);
        ydb.insertEmp(conn, "柯林芬", Dept.HR, "443456789", 44505, Gender.F);
        ydb.insertEmp(conn, "科科有", Dept.MIS, "223456789", 33505, Gender.M);
        ydb.insertEmp(conn, "科科吳", Dept.GAF, "444456789", 57505, Gender.N);
        */
        
        /*
        //新增請假記錄
        ydb.insertLeave(conn, 1, "11/11", Leave.SICK, 4);
        ydb.insertLeave(conn, 13, "11/12", Leave.PERSONAL, 8);
        ydb.insertLeave(conn, 14, "11/12", Leave.PERSONAL, 8);
        ydb.insertLeave(conn, 1, "11/11", Leave.MARRIAGE, 4);
        ydb.insertLeave(conn, 2, "11/13", Leave.FUNERAL, 4);
        ydb.insertLeave(conn, 4, "11/13", Leave.FUNERAL, 4);
        */
        
        ydb.queryEmp(conn);
        ydb.queryLeave(conn);
        ydb.queryEmpNO(conn, 4);
        ydb.queryLeaveNo(conn, 1);
        ydb.queryEmpLeave(conn);
        ydb.queryEmpLeaveJoin(conn);
        ydb.queryEmpLeaveLeftJoin(conn);
        ydb.queryEmpNotLeave(conn);
        ydb.queryEmpNotLeaveSalary(conn);
        ydb.queryDeptLeaveSum(conn);
    }
    
}
