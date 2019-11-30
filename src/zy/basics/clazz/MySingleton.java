package zy.basics.clazz;

/**
 * Created by kaiser_zhao on 2018/11/6.
 */

public enum MySingleton {
    INSTANCE;
//    private final static MySingleton mySingleton;
//    private MySingleton(){}
//    static MySingleton getInstance(){
//        if(mySingleton==null){
//            mySingleton = new MySingleton();
//        }
//        return mySingleton;
//    }
    public final static void main(){
        MySingleton mySingleton = MySingleton.INSTANCE;
    }
}
