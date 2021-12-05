package unit26myenum;

//enummeration(列舉)
//特殊的常數定義方式
//可依自己所需定義各種不同的常數型態
public enum TT {
    //一定要有有參數的建構子
    JAN("一月"),FEB("二月"),MAR("三月"),APR("四月"),MAY("五月"),JUN("六月"),
    JUL("七月"),AUG("八月"),SEP("九月"),OCT("十月"),NOV("十一月"),DEC("十二月");
    
    private final String value; //宣告為final,不能重新定義
    
    TT(String value){ //有參數的建構子,沒加這行前月份是紅線
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }
    
}






