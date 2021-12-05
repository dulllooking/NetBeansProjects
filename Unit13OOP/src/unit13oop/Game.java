
package unit13oop;
//專案右鍵New>Java Class新增Game等同放在unit13oop的package
public class Game {
    private String id;
    private String pwd;
    private String server;
    private String player="訪客";
    private int hp=100;
    private int mp=0;
    private int sp;
    private double power;
    
    //setter,getter
    public String idInfo(String id){
            this.id=id;
            return (this.id);
        }
    public String pwdInfo(String pwd){
            this.pwd=pwd;
            return (this.pwd);
        }
    public String serverInfo(String server){
            this.server=server;
            return (this.server);
        }
    public String playerInfo(String player){
            this.player=player;
            return (this.player);
        }
    public int hpInfo(int hp){
            this.hp=hp;
            return (this.hp);
        }
    public int mpInfo(int mp){
            this.mp=mp;
            return (this.mp);
        }
    public int spInfo(int sp){
            this.sp=sp;
            return (this.sp);
        }
    
    public double getPower(){
        this.power=hp*3+mp*3+sp*1.5;
        return this.power;
    }
    
    public boolean isLogin(){
        if(this.id.equals("amy") && this.pwd.equals("1234"))
            return true;
        else
            return false;
    }
    
    public void login(){
        if(isLogin()){
            System.out.println(this.server + "...連線中...");
            System.out.println(this.server + "連線成功!!");
            System.out.println("玩家:"+this.player);
            System.out.println("hp:"+this.hp);
            System.out.println("mp:"+this.mp);
            System.out.println("sp:"+this.sp);
            System.out.println("power:"+this.getPower());
        }
        else
            System.out.println("~帳密錯誤~");
    }
    
}
