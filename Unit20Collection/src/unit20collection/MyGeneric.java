package unit20collection;

/*
 *
 * 建立泛型的類別 Generic Class
 */
public class MyGeneric <T> { //<T>泛型型別
    
    private T field;
    
    public void setField(T field){
        this.field=field;
    }
    
    public T getField(){
        return this.field;
    }
    
}
