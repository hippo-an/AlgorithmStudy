package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen_9663_Gold4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] col = new int[N + 1];
        int[] result = new int[1];

        nQueen(N, 1, col, result);

        System.out.println(result[0]);
    }

    private static void nQueen(int n, int curr, int[] col, int[] result) {
        if (curr == n + 1) {
            result[0]++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            boolean isPossible = true;

            for (int j = 1; j < curr; j++) {
                if (col[j] == i || Math.abs(col[j] - i) == Math.abs(j - curr)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                col[curr] = i;
                nQueen(n, curr + 1, col, result);
                col[curr] = 0;
            }
        }
    }
}
