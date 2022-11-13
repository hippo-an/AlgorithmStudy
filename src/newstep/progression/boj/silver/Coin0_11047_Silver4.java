package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin0_11047_Silver4 {

    private static int N, K;
    private static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N + 1];

        for (int i = 1;i <= N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;

        for (int i = N; i >= 1; i--) {
            int x = coins[i];
            if (x > K) continue;
            ans += K / coins[i];
            K = K % coins[i];
        }

        System.out.println(ans);
    }
}
