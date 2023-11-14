package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PutBall_10810_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] board = new int[n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            for (int k = from - 1; k < to; k++) {
                board[k] = target;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : board) {
            sb.append(a).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
