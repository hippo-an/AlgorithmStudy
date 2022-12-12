package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PassCode_2011_Gold5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        // 0으로 시작하거나
        // 0, 1 인덱스에 대해 2자리 변환 시 20 이상인 경우 - dy[1] = 1 을 넣기 위한 조건
        boolean failureFlag = s.charAt(0) == '0'
                || (s.length() >= 2 && s.charAt(1) == '0' && s.charAt(0) > '2');

        if (failureFlag) System.out.println("0");
        else {
            int[] dy = new int[5000 + 1];
            dy[0] = dy[1] = 1;

            for (int i = 2; i <= s.length(); i++) {
                char current = s.charAt(i - 1);

                // 1. 1~9 범위
                if (current != '0') dy[i] = dy[i - 1] % 1000000;

                // 2. 10 ~ 26 범위 - 한자리 수(1~9) 두자리 수일때의 경우를 더하는 조건에 포함되면 안된다.
                int code = Integer.parseInt(s.substring(i - 2, i));
                if (10 <= code && code <= 26) {
                    dy[i] += dy[i - 2] % 1000000;
                }

                // 암호 변환이 불가능한 경우
                if (dy[i] == 0) {
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