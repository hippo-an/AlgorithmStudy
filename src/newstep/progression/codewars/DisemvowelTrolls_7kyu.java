package newstep.progression.codewars;

import java.util.Arrays;
import java.util.List;

public class DisemvowelTrolls_7kyu {
    public static String disemvowelOwn(String str) {
        List<String> list = Arrays.asList("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
        for (String s : list) {
            str = str.replace(s, "");
        }
        return str;
    }

    public static String disemvowelReg1(String str) {
        return str.replaceAll("(?i)[aeiouAEIOU]", "");
    }
    public static String disemvowelReg2(String str) {
        return str.replaceAll("[aAeEiIoOuU]", "");
    }
}
