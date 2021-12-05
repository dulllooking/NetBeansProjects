package unit23exception;
import java.io.*;

/*
 *
 * Exception例外 
 */
public class Unit23Exception {

    public static void main(String[] args) {
        
        arithmeticTest();
        arrayTest();
        multiExcepion();
        fisTest();
        
        
        System.out.println("--------自訂例外方法--------");
        try{
            int[] divide={10, 0};
            System.out.println(divide[0] + "/" + divide[1] + "=" + userMethod(divide));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("--------自訂例外方法2--------");
        try{
            FileInputStream fis=new FileInputStream(userMethod2());
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println("--------自訂例外處理--------");
        empLogin();
        
    }//end 
    
    public static void arithmeticTest(){
        int i=10;
        int j=0;
        //int k=i/j; //run throw ArithmeticException 
        double k=0;
        try{ //無例外時,執行此區塊
            k=i/j; 
            System.out.println(i + "/" + j + "=" + k);
        }catch(ArithmeticException e){ //(例外類別 例外物件) 有例外時執行此區塊
            System.out.println("分母不可為0");
            System.out.println(e.getMessage());
        }
    }

    public static void arrayTest(){
        int[] score=new int[2];
        try{
            score[0]=100;
            score[1]=95;
            score[2]=98;
            for(int i=0;i<score.length;i++){
                System.out.println("score[" + i + "]=" + score[i]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("陣列索引值超出範圍");
            System.out.println(e.getMessage());
        }
    }

    public static void fisTest(){
        String file="myfile.txt";
        try{
            FileInputStream fis=new FileInputStream(file); //提示:必須置於try{}catch{}中
            System.out.println("有找到" + file + "檔!!");
        }catch(FileNotFoundException e){
            System.out.println("找不到" + file + "檔!!");
            System.out.println(e.getMessage());
        }
    }
    
    //多重例外
    public static void multiExcepion(){
        int[] divide={10,0};
        
        try{
        double k=divide[0]/divide[1];
        divide[2]=100;
        System.out.println(divide[0] + "/" + divide[1] + "=" + k);
        }catch(ArithmeticException e){
            System.out.println("多重例外:分母不可為零," + e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("多重例外:陣列索引值超!!");
        }catch(Exception e){ //大的例外處理一定要放在最後(有繼承關係的例外大的要放後面)
            System.out.println("多重例外:" + e.getMessage());
        }finally{ //不論是否發生例外,皆會執行區塊內的敘述
            System.out.println("程式執行完畢,881");
        }
    }

    //自訂例外Method
    public static double userMethod(int[] divide)throws
                                             ArrayIndexOutOfBoundsException,
                                             ArithmeticException
        {
            if(divide.length>2)throw new ArrayIndexOutOfBoundsException("陣列索引超出範圍");
            int i=divide[0];
            int j=divide[1];
            if(j==0)throw new ArithmeticException("分母不可為零");
            double k=i/j;
            return k;
        }
    
    //自訂例外Method2
    public static String userMethod2()throws FileNotFoundException{
        
        File f=new File("myfile.txt");
        if(!f.exists()) System.out.println("無此檔案!!");
        return "myfile.txt";
    }//end
    
    //是否能夠登入企業系統
    public static void empLogin(){
        
        System.out.println("---Welcome to BSNET Employee Manager System---");
        try{
            checkId("aaaaa");
            System.out.println("登入成功!!");
            
        }catch(EmpException e){
            System.out.println(e.getMessage());
            e.callTel();
        }finally{
            System.out.println("系統執行完畢,881~");
        }
    }
    
    //使用自訂Exception 類別, 驗證員工識別碼
    public static void checkId(String id) throws EmpException{
        
        if(id.length()>4) throw new EmpException(id);
    }
    
}