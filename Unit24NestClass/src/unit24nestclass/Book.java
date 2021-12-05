package unit24nestclass;
//巢狀類別 Nest Class
public class Book {
    private int no;
    private String name;
    private String intro;
    private static int count; //static供內部類別調用
    
    public Book(){
        System.out.println("BSNET BOOL STORE");
        System.out.println("===============================");
    }
    
    public Book (String publisher){
        new Publisher(publisher); //建立內部建構子 Publisher實體
    }
    
    public Book (int no, String name){
        this.no=no;
        this.name=name;
        count++;
    }
    
    //外部類別方法
    public String getInfo(String intro){
        this.intro=intro;
        return this.intro;
    }

    //inner Class 內部類別 (檔案名稱會有$符號)
    //內部類別可以public
    //compiler class: Book$Publisher.class
    public class Stock{
        private int no;
        private int skCount;
        
        //內部類別的建構子
        public Stock(int no, int skCount){
            this.no=no;
            this.skCount=skCount;
        }
        
        //內部類別的方法
        public void showInfo(String intro){
            System.out.println("進貨編號:" + this.no); //內部類別調用自己的成員變數
            System.out.println("進貨數量:" + this.skCount); //內部類別調用自己的成員變數
            System.out.println("書籍編號:" + Book.this.no); //內部類別調用"外部類別"成員變數
            System.out.println("書籍名稱:" + Book.this.name); //內部類別調用"外部類別"成員變數
            System.out.println("書籍簡介:" + Book.this.getInfo(intro)); //內部類別調用"外部類別"成員方法
            System.out.println("書籍數量:" + Book.count); //內部類別調用"外部類別"靜態變數
        }
    }//inner end    
    
    //另一個內部類別 (檔案名稱會有$符號)
    //compiler class: Book$Stock.class
    public class Publisher{
        private String name;
        public Publisher(String name){
            this.name=name;
            System.out.println("出版社名稱:" + this.name);
        }
    }
    
    
}//outer end


