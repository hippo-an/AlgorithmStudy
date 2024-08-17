package hobby.algorithm.backtrcking;

import java.io.*;

public class NQueen_9663 {
    private static int n;
    private static int count = 0;
    // 실제로 queen 을 위해 순회하지 않고
    private static final boolean[] used1 = new boolean[100];  // 열에 배치된 퀸이 있는지 여부
    private static final boolean[] used2 = new boolean[100];  // x + y => 우상향 대각선 위에서 부터 0
    private static final boolean[] used3 = new boolean[100];  // x - y + n - 1 => 우하향 대각선 위에서 부터 0

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        solve(0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void solve(int k) {
        if (k == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used1[i] || used2[i + k] || used3[k - i + n - 1]) continue;
            used1[i] = true;
            used2[k + i] = true;
            used3[k - i + n - 1] = true;
            solve(k + 1);
            used1[i] = false;
            used2[k + i] = false;
            used3[k - i + n - 1] = false;
        }
    }
}
