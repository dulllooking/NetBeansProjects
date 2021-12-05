package unit24nestclass;

public class Unit24NestClass {
    
    //巢狀類別 Nest Class
    public static void main(String[] args) {
        Book book1=new Book(51, "一刀生於");
        Book book2=new Book(12, "不是你的孩子"); //建立Book實體
        
        Book.Stock stock1=book1.new Stock(1, 30); //以外部類別實體調用內部類別建構子,建立內部類別實體
        Book.Stock stock2=book2.new Stock(56, 15); //以外部類別實體調用內部類別建構子,建立內部類別實體
        Book.Stock stock3=new Book(103, "大三山").new Stock(4, 20); //合併寫法
        
        new Book(); //建立實體,不指定給任何物件變數
        new Book("上奇數位出版社");
        
        System.out.println("---第1筆進貨單----");
        stock1.showInfo("浪人劍客的故事");
        
        System.out.println("---第2筆進貨單----");
        stock2.showInfo("親情勒索的故事");
        
        System.out.println("---第3筆進貨單----");
        stock3.showInfo("介紹台灣三大名山");
        
    }
    
}
