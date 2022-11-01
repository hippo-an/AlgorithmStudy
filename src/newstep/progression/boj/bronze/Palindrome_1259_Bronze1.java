package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome_1259_Bronze1 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N;
        while (true) {
            N = br.readLine();
            if ("0".equalsIgnoreCase(N)) {
                break;
            }
            int L = 0;
            int R = N.length() - 1;
            boolean flag = true;

            while (L <= R) {
                char x = N.charAt(L);
                char y = N.charAt(R);

                if (x != y) {
                    flag = false;
                    break;
                }
                L++;
                R--;
            }

            if (flag) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}
