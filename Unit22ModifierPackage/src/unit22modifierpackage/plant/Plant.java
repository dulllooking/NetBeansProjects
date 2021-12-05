package unit22modifierpackage.plant;

public class Plant {
    public String kingdom; //public
    protected boolean isMove; //protected
    boolean isThink; //default
    private boolean isLeaf; //private
}


class WaterPlant extends Plant {
    public void showInfo() {
        super.kingdom="我是水中植物之王";
        super.isMove=true; //相同package
        super.isThink=false; //相同package
        //super.isLeaf=true; //private不同類別無法存取
        
    }
}