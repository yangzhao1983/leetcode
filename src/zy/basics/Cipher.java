package zy.basics;

/**
 * Created by kaiser_zhao on 2019/2/5.
 */
public class Cipher {
    public static void main(String...strings){
        String name = "YANG";
        byte[] bs = name.getBytes();
        byte[] tbs = new byte[bs.length];

        for(int i = 0; i<bs.length;i++){
            System.out.println(bs[i]);
            int tmp = bs[i] +3;
            if(tmp>90){
                tmp = tmp - 26;
            }
           tbs[i] = (byte)tmp;
            System.out.println(tbs[i]);
            System.out.println("===============");
        }
        System.out.println(new String(tbs));

    }
}
