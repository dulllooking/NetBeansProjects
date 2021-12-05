package unit26myenum;
// 繼承 java.lang.Enum
public enum Movie {
    
    MOVIE_FIRST(0),MOVIE_SECOND(6),MOVIE_THIRD(12),MOVIE_FORTH(15),MOVIE_FIFTH(18),
    DIGTAL("數位"),THREE_D("3D"),IMAX("iMAX"),FOUR_D("4D");
    
    private int age;
    private Movie(int age){ //列舉建構子不對外private
        this.age=age;
    }
    
    private String dd;
    private Movie(String dd){ //列舉建構子不對外private
        this.dd=dd;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public String getDD(){
        return this.dd;
    }
}
