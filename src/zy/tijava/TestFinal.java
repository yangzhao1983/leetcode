package zy.tijava;

/**
 * Created by kaiser_zhao on 05/04/2019.
 */
public class TestFinal {
    public static void main(String...strings){
        FinalData fd1 = new FinalData();
        FinalData fd2 = new FinalData();
        System.out.println(fd1.i == fd2.i);
    }
}

class FinalData{
    final Value i = new Value();
}

class Value{
    public Value(){

    }
}