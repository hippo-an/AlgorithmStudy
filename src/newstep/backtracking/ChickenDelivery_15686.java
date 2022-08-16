package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChickenDelivery_15686 {

    private static int N, M, ans = Integer.MAX_VALUE;
    private static int[][]  arr;
    private static int[][] chicken;
    private static boolean[][] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        chicken = new int[N + 1][2];
        arr = new int[N + 1][N + 1];
        selected = new boolean[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursiveFunction(1);
        System.out.println(ans);
    }

    private static void recursiveFunction(int X) {
        if (X == M + 1) {
            int total = 0;
            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= N; y++) {
                    if (arr[x][y]  == 1) {
                        int temp = Integer.MAX_VALUE;
                        for (int xx = 1; xx <= N; xx++) {
                            for (int yy = 1; yy <= N; yy++) {
                                if (selected[xx][yy]) {
                                    temp = Math.min(Math.abs(x - xx) + Math.abs(y - yy), temp);
                                }
                            }
                        }

                        total += temp;
                    }
                }
            }

            ans = Math.min(total, ans);
        } else {
            for (int x = 1; x <= N; x++) {
                for (int y = 1; y <= N; y++) {
                    if (arr[x][y] == 2) {
                        selected[x][y] = true;
                        recursiveFunction(X + 1);
                        selected[x][y] = false;
                    }
                }
            }
        }
    }
}
