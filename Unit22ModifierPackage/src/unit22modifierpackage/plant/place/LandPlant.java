package unit22modifierpackage.plant.place;

public class LandPlant extends unit22modifierpackage.plant.Plant {
    
    public void showInfo() {
        super.kingdom="我是水中植物之王";
        super.isMove=true; //protected 屬於相同package,因為有繼承
        //super.isThink=true; //(default)不可繼承,不同package,無法存取
        //super.isLeaf=true; //private,不同類別無法存取

    }
}
