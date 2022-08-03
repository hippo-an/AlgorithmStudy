package newstep.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * total 을 구한 후 무조건 값이 2로 나뉘어 진다는 점이 포인트
 * 처음엔 2중 루프로 작성을 했는데 시간초과가 나진 않았지만 입력이 충분히 클 경우 시간초과의 위험이 있다
 * O(N^2) -> 2차원 배열 입력
 */
public class StartLink_14889 {

    private static int N, ans = Integer.MAX_VALUE, total;
    private static int[][] arr;
    private static boolean[] selected;
    private static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        selected = new boolean[N + 1];
        scores = new int[N + 1];


        StringTokenizer st = null;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                total += (arr[i][j] = Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                scores[i] += arr[i][j] + arr[j][i];
            }
        }


        // 접근법
        recursiveFunction(1, 0);

        System.out.println(ans);
    }

    private static void recursiveFunction(int k, int value) {
        if (k == N / 2 + 1) {
            // 최소값 비교
            int temp = 0;
            for (int i = 1; i <= N; i++) {
                if (selected[i]) {
                    temp += scores[i];
                }
            }
            ans = Math.min(Math.abs(total - temp), ans);
        } else {
            for (int i = value + 1; i <= N; i++) {
                selected[i] = true;
                recursiveFunction(k + 1, i);
                selected[i] = false;
            }
        }
    }
}
