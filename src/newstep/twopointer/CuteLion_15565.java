package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CuteLion_15565 {

    private static int N, K;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int R = 0, ans = Integer.MAX_VALUE;
        int cnt = 1;


        for (int L = 1; L <= N; L ++) {
            if (arr[L] == 2) continue;
            cnt -= 1;

            while( cnt < K && R  < N) {
                R++;
                if (arr[R] == 1) cnt++;
            }
            if (cnt == K)
                ans = Math.min(ans, R - L + 1);
        }


        if (ans == Integer.MAX_VALUE)
            ans = -1;

        System.out.println(ans);

    }
}
