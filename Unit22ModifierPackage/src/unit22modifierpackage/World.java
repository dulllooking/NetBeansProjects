package unit22modifierpackage;
import unit22modifierpackage.plant.Plant;
/*
 *
 * 存取修飾子 modifier,套件 package
 * Public : 任何類別皆可存取
 * Protected : 不同package,但有繼承,可存取
 * (default) : 相同package才可存取
 * Private : 只有自類別內才可存取
 */
public class World {
    public static void main(String[] args){
        Animal animal=new Animal();
        animal.kingdom="我是森林之王,獅子"; //public任何宣告類別皆可存取
        animal.isMove=true; //protected (保護的) 相同package 可以存取
        animal.isThink=true; //(default,預設) 相同package 可以存取
        //animal.leg=2; //private(私有的), 存取範圍, 只在自己類別內
        animal.getLeg(); //privat宣告使用方式
        
        Plant plant=new Plant();
        plant.kingdom="水中植物"; //public, 可以存取
        //plant.isMove=true; //protected不同package, 無法存取
        //plant.isThink=true; //(default)不同package, 無法存取
        //plant.isLeaf=true; //private, 無法存取
    }
}
