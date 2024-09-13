package hobby.algorithm.backtrcking;

import java.io.*;
import java.util.StringTokenizer;

public class StartAndLink_14889 {
    static int n;
    static int ans = Integer.MAX_VALUE;
    static boolean[] selected;
    static int[][] board;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                total += board[i][j];
            }
        }

        selected = new boolean[n];
        recursive(0, 0);
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static void recursive(int k, int prev) {
        if (k == n/2) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (selected[i] &&  selected[j]) {
                        start += board[i][j];
                        start += board[j][i];
                    } else if (!selected[i] &&  !selected[j]) {
                        link += board[i][j];
                        link += board[j][i];
                    }
                }
            }

            ans = Math.min(ans, Math.abs(start - link));
            return;
        }

        for (int i = prev; i < n; i++) {
            if (selected[i]) {
                continue;
            }

            selected[i] = true;
            recursive(k + 1, i+ 1);
            selected[i] = false;
        }
    }
}
