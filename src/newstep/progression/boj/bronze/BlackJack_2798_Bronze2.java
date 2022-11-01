package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack_2798_Bronze2 {
    private static int N, M, ans = Integer.MIN_VALUE;
    private static int[] arr;
    private static boolean[] selected;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        selected = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());

        bfs(1, 0);
        System.out.println(ans);
        br.close();
    }

    private static void bfs(int k, int sum) {
        if (k == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 1;i <= N; i++) {
            if (!selected[i]) {
                if (sum + arr[i] <= M) {
                    selected[i] = true;
                    bfs(k + 1, sum  + arr[i]);
                    selected[i] = false;
                }
            }
        }
    }
}
