package zy.basics.javacore;

import java.io.*;

/**
 * Created by kaiser_zhao on 2019/1/16.
 */
public class TestUnicode {
    public static void main(String...strings){
        // test output unicode string
        String str = "食";
        String str2 = "\u2122";
        String str3 = "\u1D546";

        System.out.println(System.getProperty("file.encoding"));
        System.out.println(str.length());
        System.out.println(str2.length());
        System.out.println(str3.length());
        System.out.println(str.getBytes().length);
        System.out.println(str2.getBytes().length);
        System.out.println(str3.getBytes().length);

        System.out.println(str.codePoints().count());
        System.out.println(str2.codePoints().count());
        System.out.println(str3.codePoints().count());


        System.out.println(str.toCharArray().length);
        System.out.println(str2.toCharArray().length);
        System.out.println(str3.toCharArray().length);
        for(Byte b : str.getBytes()){
            System.out.printf("%h\n", b);
        }

        int c = 0;
        int strlen = str.length();
        for (int i = 0; i < strlen; i++) {
            c = str.charAt(i);
            System.out.printf("%h\n", c);
        }

        try(OutputStream os = new FileOutputStream("test.txt")){

            os.write(str.getBytes());
        }catch (FileNotFoundException e){
            System.out.println("File not found exception");
        }catch (IOException e){
            System.out.println("IO exception");
        }

        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("test_dop.txt")))){

            dos.writeUTF(str);
        }catch (FileNotFoundException e)
        {

        }catch (IOException e){

        }
    }

}
