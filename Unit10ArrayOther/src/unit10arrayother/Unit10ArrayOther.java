
package unit10arrayother;

/*
 陣列
 */
public class Unit10ArrayOther {
    
    public static void main(String[] args) {
        String[] leisure={"打怪","跑步","看電影","看書","爬山","睡覺"};
        String[] favorite=new String[4];
        int[] score={10,50,40,90,70};
        String greeting=""; //記錄動態陣列長度
        int[] lucky; ////記錄動態陣列,長度依greeting字串長度來決定
        java.util.Scanner sc=new java.util.Scanner(System.in);
        
        
        System.out.println("---休閒項目---");
        for(String e:leisure)
            System.out.print(e + "");
        
        //複製陣列
        //arrsycopy(來源,起始索引編號,目的地,複製數量,複製陣列長度) //沒有的值填null
        System.arraycopy(leisure, 1, favorite, 1, 2);
        System.out.println("\n---最愛項目---");
        for(String e:favorite)
            System.out.print(e + "");
        System.out.println();
        
        char[] from={'I',' ','l','o','v','e',' ','j','a','v','a'};
        char[] to=java.util.Arrays.copyOfRange(from, 7, 11); //不import套件要打全部
        //copyOfRange(來源,從索引號幾號開始,取到哪個索引號前)
        System.out.println("---for each---");
        for(char e:from){
            System.out.print(e);
        }
        System.out.println("\n---new String---");
        System.out.println(new String(from));   //轉字串輸出
        System.out.println(new String(to));
        
        System.out.println("---排序前---");
        for(int e:score){
            System.out.print(e+" ");
        }
        
        //陣列的排序
        java.util.Arrays.sort(score);
        System.out.println("\n---排序後---");
        for(int e:score){
            System.out.print(e+" ");
        }
        
        //動態配置陣列長度
        System.out.println("\n請輸入一句問候語:");
        greeting=sc.next();
        lucky=new int[greeting.length()];
        for(int i=0;i<lucky.length;i++){
            int r=(int)Math.floor(Math.random()*49)+1; //(int)強制轉型random的浮點數
            lucky[i]=r;
        }
        
        for(int e:lucky){
            System.out.print(e + "  ");
        }
        sc.close();
    }
    
}
