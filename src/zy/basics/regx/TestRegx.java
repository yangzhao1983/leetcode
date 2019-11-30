package zy.basics.regx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kaiser_zhao on 22/03/2019.
 */
public class TestRegx {
    public static void main(String... strings) {
        String idInText = "sdfadfasdfs12133124434v running.";
        String id = "";
        // remove space
        idInText = idInText.replaceAll("\n", "");

        Pattern p = Pattern.compile("\\b[a-zA-Z0-9]{20,}\\b");
        Matcher m = p.matcher(idInText);
        if (m.find()) {
            id = idInText.substring(m.start(), m.end());
            System.out.println("get it");
        }

        System.out.println(id);
    }
}
