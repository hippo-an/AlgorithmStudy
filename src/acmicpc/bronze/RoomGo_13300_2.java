package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoomGo_13300_2 {

    private static int n, k;
    private static int[][] arr = new int[2][6];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) - 1;

            arr[s][y]++;
        }

        int ans = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }

                if (arr[i][j] % k == 0) {
                    ans += arr[i][j] / k;
                } else {
                    ans += arr[i][j] / k + 1;
                }
            }
        }

        System.out.println(ans);

        br.close();
    }
}
