package unit02datatype;

public class Unit02DataType {

    /*
     資料基本型別 Primitive Type:java八大基本型別(char,byte,short,int,long,float,double,boolean)
     參照型別 Reference Type:String(字串)
     常數:
    
    "=" 指派or指定 (運算)
    "==" 等於 (比較)
     */
    
    public static void main(String[] args) {
        
        //資料基本型別 Primitive Type:
        //字元型別:char
        //語法:
        //資料型別 變數名稱=變數的值
        char gender='M';    //將字元M指定給字元gender
        char age='A';
        char grade=65;      //ASCII
        char grade2='\u0041';       //Unicode
        
        //整數型別:byte short int long
        
        //byte:2^8=256 (-128~127)
        byte room=1;
        byte room2=127;
        //byte room3=128; (無法執行)
        
        //short:2^16=65536 (-32768~32767)
        short stuNo=1000;
        short stuNo2=10000;
        //short stuNo3=32768; (無法執行)
        
        //int:2^32 (-2^31~2^31 -1)
        int money=10000;
        int money2=100000000;
        //int money3=10000000000;  (無法執行)
        
        //long:2^64 (-2^63~2^63 -1) 值後方要加L或l(小寫)
        long price=123456789L; //沒加L會自動轉型(變int)
        long price2=123456789l; //小寫L不易辨識(不要使用)
        //long price3=123456789123456789; (無法執行:沒加L,整數預設是int超出範圍)
        
        //整數的表示:10,16,2,8 (進制)
        int dec=255;    //10進制
        int hex=0xff;   //16進制=255
        int bin=0b11111111; //2進制=255
        int oct=0377;   //8進制=255
        
        //關於顏色數值 R:0~255(2^8=256) G:0~255(2^8=256) B:0~255(2^8=256) 
        int red=0x80;
        int white=0xffffff;
        
        //計算練習
        int chi=50, eng=30, math=60, total=0;
        total=chi+eng+math;
        
        //浮點數:float double (預設為double)
        float ave=0.123f;   //要加f or F (否則會error)
        float ave2=(float)total/3;  //total為int須轉型為float
        double latitude=22.637212;  //緯度,double型別
        double longitude=120.302763d;   //經度,可加D or d 或都不加
        
        //BMI計算
        float h=0.0f, w=0.0f;   //先指定初值
        double bmi=0.0;
        double bmi2=0.0;
        
        h=180.5f;
        w=75.5f;
        bmi=w/((h/100)*(h/100));
        bmi2=w/Math.pow(h/100,2);
        
        //布林boolean: false, true
        boolean isPass=false;
        isPass=(bmi<24) && (bmi>=18.5);
        
        //參照型別 Reference Type:
        String stuName="科及爸";    //宣告一個字串參照型別變數(將"科及爸"指定給變數)
        String stuName2="";  //空字串
        String stuName3=new String("爭有錢");   //創建一個字串(指定給stuName3物件變數)
        
        stuName2="愛台玩";
                
        //常數:執行過程中值不會改變
        final double PI=3.14159;    //使用final關鍵字
        //PI=3.14;  //無法執行error因為常數是不可變(final)
        double rr=100.0;
        double area=rr*rr*PI;
        
        final int MAX_LEVEL=100;    //常數Constant命名用全部用大寫,用底線區隔
        final int MIN_LEVEL=1;
        int playerLevel=30;
        String pass="";
        pass=(playerLevel>=MAX_LEVEL)?"Congratulation!!":"Go!Go!"; //比較()?"成立":"不成立"
        
        
        
        System.out.println("性別:"+gender);
        System.out.println("年齡:"+age);
        System.out.println("等級:"+grade);
        System.out.println("等級:"+grade2);
        
        System.out.println("班級:"+room);
        System.out.println("班級:"+room2);
        
        System.out.println("學號:"+stuNo);
        System.out.println("學號:"+stuNo2);
        
        System.out.println("存款:"+money);
        System.out.println("存款:"+money2);
        
        System.out.println("身價:"+price);
        System.out.println("身價:"+price2);
        
        System.out.println("10進制:"+dec);
        System.out.println("16進制:"+hex);
        System.out.println("2進制:"+bin);
        System.out.println("8進制:"+oct);
        
        System.out.println("紅色:"+red);    //128
        System.out.println("RGB白色:"+white);  //16777215
        System.out.println("RGB白色:"+Integer.toHexString(white).toUpperCase());
        
        System.out.println("---學生成績---");
        System.out.println("國文成績:"+chi);
        System.out.println("英文成績:"+eng);
        System.out.println("數學成績:"+math);
        System.out.println("總分:"+total);
        
        System.out.println("ave:"+ave);
        System.out.println("平均:"+ave2);
        
        System.out.println("---電腦教育中心位置經緯度---");
        System.out.println("緯度:"+latitude);
        System.out.println("經度:"+longitude);
        
        System.out.println("---BMI 身體質量指數---");
        System.out.println("身高cm:"+h);
        System.out.println("體重kg:"+w);
        System.out.println("BMI:"+bmi);
        System.out.println("BMI:"+bmi2);
        System.out.println("BMI是否標準:"+isPass);
        
        System.out.println("同學1號:"+stuName);
        System.out.println("同學2號:"+stuName2);
        System.out.println("同學3號:"+stuName3);
        
        System.out.println("---圓形面積---");
        System.out.println("半徑:"+rr+"公尺");
        System.out.println("PI:"+PI);
        System.out.println("圓的面積:"+area+"平方公尺");
        
        System.out.println("---遊戲等級---");
        System.out.println("最高等級:"+MAX_LEVEL);
        System.out.println("最低等級:"+MIN_LEVEL);
        System.out.println("目前等級:"+playerLevel);
        System.out.println("是否過關:"+pass);
        
        
    }
    
}
