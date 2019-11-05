package zy.basics.tstream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kaiser_zhao on 2019/11/5.
 */
public class ConcatCharToString {
    public static void main(String...strings){
        Character[] cs = {'a','b','c'};
    }
    public void whenStringConstructor_thenOK() {
        final char[] charArray = { 'b', 'a', 'e', 'l', 'd', 'u', 'n', 'g' };
        String string = new String(charArray);
    }

    public void whenStringValueOf_thenOK() {
        final char[] charArray = { 'b', 'a', 'e', 'l', 'd', 'u', 'n', 'g' };
        String string = String.valueOf(charArray);
    }

    public void whenStringBuilder_thenOK() {
        final char[][] arrayOfCharArray = { { 'b', 'a' }, { 'e', 'l', 'd', 'u' }, { 'n', 'g' } };
        StringBuilder sb = new StringBuilder();
        for (char[] subArray : arrayOfCharArray) {
            sb.append(subArray);
        }
    }

    public void whenStreamCollectors_thenOK() {
        final Character[] charArray = { 'b', 'a', 'e', 'l', 'd', 'u', 'n', 'g' };
        Stream<Character> charStream = Arrays.stream(charArray);
        String string = charStream.map(String::valueOf).collect(Collectors.joining());
    }

}
