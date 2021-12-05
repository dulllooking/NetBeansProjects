package unit25io;

public class Employee {
    
    private int empNo;
    private String empName;
    private String empDept;
    private double empSalary;
    
    public Employee(int empNo, String empName, String empDept, double empSalary) {
        this.empNo=empNo;
        this.empName=empName;
        this.empDept=empDept;
        this.empSalary=empSalary;
    }
    
    public String getEmpInfo(){
        return this.empNo + "," + this.empName + "," + this.empDept + "," + this.empSalary;
    }
} //Employee end

