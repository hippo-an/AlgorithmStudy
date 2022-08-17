package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialSum_1806 {

    private static int N , S;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        S = Integer.parseInt(s[1]);
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int R = 0, L = 1;
        int ans = N + 1;
        int sum = 0;
        while(R  <= N && L <= N) {
            if (sum >= S) {
                ans = Math.min(ans, R - L + 1);
                if (L <= N) sum -= arr[L];
                L++;
            } else {
                R++;
                if (R <= N) sum += arr[R];
            }
        }

        if (ans == N + 1) ans = 0;

        System.out.println(ans);
    }
}
