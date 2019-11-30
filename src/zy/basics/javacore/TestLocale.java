package zy.basics.javacore;

import java.util.Locale;
import static zy.basics.javacore.Utils.print;

/**
 * Created by kaiser_zhao on 2019/1/23.
 */
public class TestLocale {
    public static void main(String... strings){
        Locale l = Locale.getDefault();
        print(l.getDisplayName());
        print(l.toLanguageTag());
    }
}
