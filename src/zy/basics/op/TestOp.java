package zy.basics.op;

/**
 * Created by kaiser_zhao on 2/21/18.
 */
public class TestOp {
    public static void main(String... strings){

        // create a literals number
        int bit1 = 0b011;

        // it is printed as "3"?
        System.out.println(bit1);

        // it is printed as "1"?
        int bit11 = bit1 >> 1;
        System.out.println(bit11);

        printOneLine();

        // what is it printed?
        /**
         =====================
         0000000000000000000000000000001
         -1073741824
         0000000000000000000000000000011
         1610612736
         00000000000000000000000000000001
         -2147483648
         =====================
         *
         *
         */
        int bit12 = bit1 << 30;
        printNumInBinaryMode(bit12);
        System.out.println(bit12);

        int bit13 = bit1 << 29;
        printNumInBinaryMode(bit13);
        System.out.println(bit13);


        int bit14 = bit1 << 31;
        printNumInBinaryMode(bit14);
        System.out.println(bit14);

        printOneLine();

        // No difference for positive numbers
        int bit15 = bit1 >>> 1;
        printNumInBinaryMode(bit15);
        System.out.println(bit15);

        // create a negative literals number
        int bit2 = -0b011;

        // It is printed as "-3"? Yes
        System.out.println(bit2);

        printOneLine();
        int bit3 = -0b010;
        int bit31 = bit3 >> 1;
        System.out.println(bit31);

        int bit32 = bit3 >>> 1;
        System.out.println(bit32);

        printOneLine();
        int bit4 = -0b011;

        int bit42 = bit4 >> 1;
        System.out.println(bit42);

        int bit41 = bit4 >>> 1;
        System.out.println(bit41);
    }

    /**
     * Print the number in binary mode
     *
     * @param number
     */
    private static void printNumInBinaryMode(int number){
        if(number == 0){
            printString("\n");
            return;
        }else{
            if(number % 2 == 0){
                printString("0");
            }else{
                printString("1");
            }
            printNumInBinaryMode(number/2);
        }
    }

    private static void printString(String str){
        System.out.print(str);
    }

    private static void printOneLine(){

        printString("\n=======================\n");
    }
}
