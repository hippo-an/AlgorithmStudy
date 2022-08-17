package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ChickenDelivery_15686 {

    private static int N, M, ans = Integer.MAX_VALUE;
    private static int[][] house = new int[101][2], chicken = new int[14][2];
    private static boolean[] selected = new boolean[14];

    private static int hCnt = 1, cCnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    house[hCnt][0] = i;
                    house[hCnt][1] = j;
                    hCnt++;
                } else if (val == 2) {
                    chicken[cCnt][0] = i;
                    chicken[cCnt][1] = j;
                    cCnt++;
                }
            }
        }

        recursiveFunction(1, 0);
        System.out.println(ans);
    }

    private static void recursiveFunction(int T, int idx) {
        if (T == M + 1) {
            int total = 0;
            for (int i = 1; i < house.length; i++) {
                if (house[i][0] != 0 && house[i][1] != 0) {
                    int temp = Integer.MAX_VALUE;
                    for (int j = 1; j < chicken.length; j++) {
                        if (selected[j]) {
                            int dist = Math.abs(chicken[j][0] - house[i][0]) + Math.abs(chicken[j][1] - house[i][1]);
                            temp = Math.min(temp, dist);
                        }
                    }
                    total += temp;
                }
            }
            ans = Math.min(ans, total);
            return;
        }
        for (int i = idx + 1; i < chicken.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                recursiveFunction(T + 1, idx);
                selected[i] = false;
            }
        }

    }
}
