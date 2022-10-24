package newstep.progression.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideSum_2231_Bronze2 {
    private static int N;
    private static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        length = s.length();
        N = Integer.parseInt(s);

        int ans = 0;
        for (int i = (N - (length * 9));  i < N; i++) {
            int num = i;
            int sum = 0;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }

            if ( sum + i == N) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }


}
