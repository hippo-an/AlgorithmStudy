package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NnM_15649 {

    private static int N, M;
    private static int[] ANS;
    private static boolean[] SELECTED;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        input();

        recursiveFunction(1);
        System.out.println(sb.toString());

    }

    private static void recursiveFunction(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(ANS[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (SELECTED[i]) continue;

                ANS[k] = i;
                SELECTED[i] = true;
                recursiveFunction(k + 1);

                ANS[k] = 0;
                SELECTED[i] = false;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ANS = new int[M + 1];
        SELECTED = new boolean[N + 1];
    }
}
