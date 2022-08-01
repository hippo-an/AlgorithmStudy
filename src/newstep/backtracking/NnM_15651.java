package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NnM_15651 {

    private static int N, M;
    private static int[] ANS;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        recursiveFunction(1);

        System.out.println(sb.toString());
    }

    private static void recursiveFunction(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(ANS[i]).append(" ");
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                ANS[k] = i;
                recursiveFunction(k + 1);
                ANS[k] = 0;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ANS = new int[M + 1];
    }
}
