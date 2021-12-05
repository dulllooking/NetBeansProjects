package unit29lambda;

public class Unit29Lambda {

    public static void main(String[] args) {
        
        //一般寫法
        Runnable r=new Runnable(){
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        };
        new Thread(r,"一般匿名寫法").start();
        
        //Lambda寫法
        Runnable rr=()->System.out.println(Thread.currentThread().getName());
        new Thread(rr,"Lambda寫法").start();
        
        
        //一般寫法,有一個參數
        Person p=new Person(){
            public void showPerson(String name){
                System.out.println("這個人的名字是 : " + name);
            }
        };
        p.showPerson("愛台玩");
        
        //Lambda寫法,有一個參數
        Person pp=(name)->System.out.println("這個人的名字是 : " + name);
        pp.showPerson("Jack");
        
        
        //Lambda寫法,多個參數,多行陳述(要加大括號)
        //Calc c=(x, y, e)->{ //自動辨別參數型別
        Calc c=(int x,int y,char e)->{
            double z=0.0;
            switch(e){
                case '+':
                    z=x+y;
                    break;
                case '-':
                    z=x-y;
                    break;
                case '*':
                    z=x*y;
                    break;
                case '/':
                    z=x/y;
                    break;    
            }
            System.out.println("" + x + e + y + "=" + z); //""不加e為'/'會被轉成ASCII數字47,去計算相加
        };                     //因為出現+會以為你要進行計算,所以字符會被轉數字,加""才會被認為是字串串接
        c.showCalc(10, 3, '/');
        
        
        //有傳回值,單行陳述
        Computer com=(ram,bit)->ram + "GB," + bit + "位元";
        System.out.println(com.showComputer(256, 64));
        
        //有傳回值,多行陳述
        Computer com2=(ram, bit)->{
            //....此處放其他code敘述
            return ram + "GB," + bit + "位元";
        };
        System.out.println(com2.showComputer(128, 64));
        
        
    }
    
}
