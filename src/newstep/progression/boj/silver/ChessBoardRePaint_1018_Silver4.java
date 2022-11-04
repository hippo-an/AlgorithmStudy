package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessBoardRePaint_1018_Silver4 {

    private static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for (int x = 0; x < N; x++) {
            String s = br.readLine();
            for (int y = 0; y < M; y++) {
                char c = s.charAt(y);
                if ('W' == c) arr[x][y] = true;
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int x = 0; x <= N - 8; x++) {
            for (int y = 0; y <= M - 8; y++) {
                ans = Math.min(check(x, y), ans);
            }
        }
        System.out.println(ans);

    }

    private static int check(int x, int y) {
        // 첫칸이 검은색인 경우와 흰색인 경우를 나눠서 둘다 확인 후 더 작은 값으로 리턴
        // 검은색인 경우
        int ans = 0;
        boolean first = false;

        ans = getAns(x, y, first);

        return Math.min(ans, getAns(x, y, !first));
    }

    private static int getAns(int x, int y, boolean first) {
        int ans = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (arr[i][j] != first) {
                    ans++;
                }
                first = !first;
            }
            first = !first;
        }
        return ans;
    }
}
