package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PassCode_2011_Gold5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();


        int[] dy = new int[5000 + 1];
        boolean failureFlag = s.charAt(0) == '0'
                || (s.length() >= 2 && (s.charAt(s.length() - 1) == '0' && s.charAt(s.length() - 2) > '2'))
                || (s.length() >= 2 && (s.charAt(1) == '0' && s.charAt(0) > '2'));

        if (failureFlag) System.out.println("0");
        else {
            dy[0] = dy[1] = 1;

            for (int i = 2; i <= s.length(); i++) {
                char current = s.charAt(i - 1);

                if (current != '0') dy[i] = dy[i - 1] % 1000000;

                int code = Integer.parseInt(s.substring(i - 2, i));
                if (10 <= code && code <= 26) {
                    dy[i] += dy[i - 2] % 1000000;
                } else if (dy[i] == 0 && (code == 0 || code > 26)) {
                    failureFlag = true;
                    break;
                }
            }

            if (failureFlag) {
                System.out.println("0");
            } else {
                System.out.println(dy[s.length()] % 1000000);
            }


        }
    }
}
