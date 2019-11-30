package zy.basics;

/**
 * Created by kaiser_zhao on 2019/2/6.
 */
public class TestBit {
    public static void main(String... strings){

        int i = 0xfe;
        int i1 = 0xffff;
        byte b2 = -0x7f;
//        System.out.println(Integer.toBinaryString(i));
//        System.out.println(Integer.toBinaryString(i1));
        int i2 = b2 & 0xff;
        System.out.println(Integer.toBinaryString(i2));
//        System.out.println(Byte.toUnsignedInt(b2));

        int i3 = b2 & 0xff;
//        System.out.println(Integer.toBinaryString(i3));

        // int int1 = byte1 & 0xff;
        byte b3 = 20;
        int i4 = b3 & 0xff;
//        System.out.println(Integer.toString(i4, 16).toUpperCase());

        byte[] bs = {0x11, -0x7f};
//        System.out.println(Arrays.toString(bs));

    }
}
