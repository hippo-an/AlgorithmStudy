package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NnM_2 {

    private static int N, M;
    private static int[] ANS;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        recursiveFunction(1, 1);

        System.out.println(sb.toString());
    }

    private static void recursiveFunction(int k, int s) {
        if (k == M + 1) {
            for (int i = 1; i < ANS.length; i++) {
                sb.append(ANS[i]).append(' ');
            }
            sb.append("\n");
        } else {
            for (; s <= N; s++) {
                ANS[k] = s;
                recursiveFunction(k + 1, s + 1);
                ANS[k] = 0;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(sb.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ANS = new int[M + 1];
    }
}
