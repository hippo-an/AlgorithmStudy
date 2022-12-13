package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnalysisString_10820_Bronze2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s == null  || s.length() == 0) {
                break;
            }

            int l = 0, u = 0, n = 0, w = 0;
            for (char c : s.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    l++;
                }
                else if (Character.isUpperCase(c)) {
                    u++;
                } else if (Character.isDigit(c)) {
                    n++;
                } else if (Character.isWhitespace(c)) {
                    w++;
                }
            }

            sb.append(l).append(" ")
                    .append(u).append(" ")
                    .append(n).append(" ")
                    .append(w).append("\n");
        }

        System.out.println(sb);
    }
}
