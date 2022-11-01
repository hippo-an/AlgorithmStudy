package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheckNumber_2475_Bronze5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 1; i <= 5; i++) {
            int x = Integer.parseInt(st.nextToken());
            ans += (x * x);
        }
        System.out.println(ans % 10);
        br.close();
    }
}
