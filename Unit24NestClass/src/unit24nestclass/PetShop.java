package unit24nestclass;

//內部匿名類別
public class PetShop {
    
    public static void main(String[] args){
        
        //Pet pet=new Pet(); //interface沒有建構子無法實體
        
        //匿名類別無法實體,所以直接實作Pet 介面
        Pet dog=new Pet(){
            public void skill(){ //實作介面方法
                System.out.println("我會接飛盤!!");
            }
            public void move(){ //實作介面方法
                System.out.println("我會跑來跑去~");
            }
        }; //;匿名 end
        
        Pet cat=new Pet(){
            public void skill(){ //實作介面方法
                System.out.println("我會惡搞!!");
            }
            public void move(){ //實作介面方法
                System.out.println("我會跳來跳去~");
            }
        }; //;匿名 end
        
        dog.skill();
        dog.move();
        cat.skill();
        cat.move();
        
        
        //實作介面的匿名類別
        //(new Pet(){ //OK,另一種寫法頭尾用()
        new Pet(){
          @Override
          public void skill(){}
          @Override
          public void move(){}
          
          //匿名類別,可以有自己的方法
          public void eat(){
              System.out.println("我是紅龍,我愛吃蟑螂~");
              System.out.println("所以我" + Pet.attr);
          }
        }.eat(); //調用自己的方法
        //}).eat(); //OK,另一種寫法頭尾用()
        
        
        //匿名類別繼承類別
        Shop shop=(new Shop(123.123){
            //override super class method
            
            @Override
            public double getAmount(){
                return super.amount;
            }
            
            //自訂方法,型別為Shop
            public Shop showInfo(){
                System.out.println("北高雄寵物跳樓大拍賣!!");
                return new Shop(123.123);
            }
        }).showInfo();
        
        //調用匿名類別的方法
        System.out.println("消費總額:" + shop.getAmount());
        
        Shop shop2=(new Shop(321.321){
            
            //自訂方法,型別為Shop 
            public Shop showInfo(){
                System.out.println("南高雄寵物跳樓大拍賣!!");
                return new Shop(321.321);
            }
        }).showInfo();
    
        //調用匿名類別的方法
        System.out.println("消費總額:" + shop2.getAmount());
        
    } //main end
} //PetShop class end

interface Pet{
    String attr="可愛到不行~";
    
    public void skill(); //interface不可以有實體body{}

    public void move();
} //Pet end

class Shop{
    double amount;
    
    public Shop(double amount){
        this.amount=amount;
    }
    
    public double getAmount(){
        return this.amount;
    }
    
}