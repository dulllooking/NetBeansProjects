package unit22modifierpackage;

//midifier 存取修飾子 ,public, protected, (default), private
public class Animal {
    public String kingdom; //public
    protected boolean isMove; //protected
    boolean isThink; //default
    private int leg; //private
    public int getLeg(){return this.leg;} //privat宣告使用方式
}
