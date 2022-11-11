package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MineCraft_18111_Silver2 {
    private static int time, N, M, B, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    private static int[][] blocks;
    private static int[] blockCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        blocks = new int[N + 1][M + 1];
        blockCnt = new int[257];

        for (int i = 1;i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
                blockCnt[blocks[i][j]]++;
                if (blocks[i][j] < min) min = blocks[i][j];
                if (blocks[i][j] > max) max = blocks[i][j];
            }
        }

        // min 부터 max 까지 전부 채워본다.
        int duration = Integer.MAX_VALUE;
        int height = 0;

        for ( int i = min; i <= max; i++) {
            // 만약 채울 수 있다면

            if (flat(i) && time <= duration) {
                // 그 수를 받는다.
                duration = time;
                height = i;
            }
        }

        System.out.println(duration + " " + height);
    }

    private static boolean flat(int x) {
        int tempTime = 0;
        int tempBag = B;

        for (int i = max; i >= min; i--) {
            if (i > x) {
                tempBag += (i - x) * blockCnt[i];
                tempTime += (2 * blockCnt[i] * (i - x));
            } else if (i < x) {
                int t = (x - i) * blockCnt[i];
                if (t > tempBag) return false;
                tempBag -= t;
                tempTime += blockCnt[i] * (x - i);
            }
        }
        time = tempTime;
        return true;
    }
}
