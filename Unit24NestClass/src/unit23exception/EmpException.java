package unit23exception;

//自訂例外類別
public class EmpException extends Exception{
    
    public EmpException(String id){
        super("員工識別碼" + id + "驗證失敗");
    }
    
    public void callTel(){
        System.out.println("請撥打資訊室電話:8825252");
    }
    
}
