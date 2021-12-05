package unit26myenum;

public class Unit26MyEnum {

    public static void main(String[] args) {
        showSeason(T.WINTER);
        System.out.println(TT.NOV.getValue()); //透過列舉TT調用NOV常數再調用getValue()取得值
        System.out.println("---中英文月份對照---");
        for(TT e: TT.values()){ //傳回列舉類所有的常數(陣列),官方文件:隱函式靜態方法
            System.out.println(e + "-->" + e.getValue());
        }
        
        showMovie(Movie.MOVIE_FIFTH);
        System.out.println(Movie.IMAX.getDD());
        System.out.println("---台灣電影分級與電影院的種類---");
        for (Movie e : Movie.values()){ //傳回列舉類所有的常數(陣列)
            //if(e.getAge() != 0) System.out.println(e + "-->" + e.getAge()); //缺0項
            //if(e.getDD() != null) System.out.println(e + "-->" + e.getDD());
            if(e.getDD() == null)
                System.out.println(e + "-->" + e.getAge());
            else
                System.out.println(e + "-->" + e.getDD());
        }
        System.out.println("---使用 ordinal(),依宣告常數時位置順序---");
        for(Movie e:Movie.values()){
            if(e.ordinal() < 5)
                System.out.println(e + "-->" + e.getAge());
            else
                System.out.println(e + "-->" + e.getDD());
        }
        System.out.println("---使用 toString(),依宣告時的常數名---");
        for(Movie e:Movie.values()){
            if(e.toString().startsWith("MOVIE"))
                System.out.println(e + "-->" + e.getAge());
            else
                System.out.println(e + "-->" + e.getDD());
        }
        System.out.println("---使用 name(),列舉的常數名---");
        for(Movie e:Movie.values()){
            if(e.name().startsWith("MOVIE"))
                System.out.println(e + "-->" + e.getAge());
            else
                System.out.println(e + "-->" + e.getDD());
        }
    } //main end
    
    
    //對應的季節
    public static void showSeason(T season){
        
        switch(season){
            case SPRING:
                System.out.println("春天");
                break;
                
            case SUMMER:
                System.out.println("夏天");
                break;
            
            case FALL:
                System.out.println("秋天");
                break;
            
            case WINTER:
                System.out.println("冬天");
                break;    
        }
    } //T end
 
    //對應的電影分級
    public static void showMovie(Movie movie){
        switch(movie){
            case MOVIE_FIRST:
                System.out.println(Movie.MOVIE_FIRST.getAge() + "歲可以看普通級");
                break;
                
            case MOVIE_SECOND:
                System.out.println(Movie.MOVIE_SECOND.getAge() + "歲可以看保護級");
                break;
                
            case MOVIE_THIRD:
                System.out.println(Movie.MOVIE_THIRD.getAge() + "歲可以看保護級");
                break;
                
            case MOVIE_FORTH:
                System.out.println(Movie.MOVIE_FORTH.getAge() + "歲可以看輔導級");
                break;
                
            case MOVIE_FIFTH:
                System.out.println(Movie.MOVIE_FIFTH.getAge() + "歲可以看限制級");
                break;
        }
    }
}
