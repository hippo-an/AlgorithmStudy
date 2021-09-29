package ezsw.kakao.k2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IDGenerate {
    public static void main(String[] args) {

    }

    boolean isValid (char c) {
        if(Character.isLetterOrDigit(c)) return true;
        if(c == '.' || c == '-' || c == '_') return true;
        return false;
    }

    private String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        boolean lastDot = false;

        for(char ch : new_id.toCharArray()) {
            if(!isValid(ch)) continue;
            if(ch == '.') {
                if(answer.length() == 0 || lastDot) continue;
                lastDot = true;
            } else lastDot = false;

            ch = Character.toLowerCase(ch);
            answer.append(ch);
        }

        if(answer.length() >= 16) answer.setLength(15);

        if(answer.length() == 0) answer.append('a');

        if(answer.charAt(answer.length() - 1) == '.') answer.deleteCharAt(answer.length() - 1);

        if (answer.length() < 3) {
            char ch = answer.charAt(answer.length() - 1);
            while(answer.length() < 3) answer.append(ch);
        }
        Arrays.sort("ADBSS".toCharArray());
        return answer.toString();
    }
}
