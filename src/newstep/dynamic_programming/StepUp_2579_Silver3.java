package newstep.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StepUp_2579_Silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N + 1];
        for (int i = 1;i <= N;i ++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 0 - 1칸을 밟고 올라오는 합계
        // 1 - 2칸을 밟고 올라오는 합계
        int[][] dy = new int[N + 1][2];

        dy[1][0] = score[1];
        if (N > 1) {
            dy[2][0] = score[1] + score[2];
            dy[2][1] = score[2];
        }

        for (int i = 3; i <= N; i++) {
            dy[i][0] = dy[i - 1][1] + score[i];
            dy[i][1] = Math.max(dy[i - 2][0] + score[i], dy[i - 2][1] + score[i]);
        }

        System.out.println(Math.max(dy[N][0], dy[N][1]));
    }
}
