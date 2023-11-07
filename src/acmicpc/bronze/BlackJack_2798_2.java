package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 100 장 중 3장을 선택해서 그 합이 M 과 가장 가깝도록 최적화 하는 문제
//
public class BlackJack_2798_2 {

    private static int N;
    private static int M;

    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        choose(arr, new int[4], new boolean[N + 1], 1);
        bruteForce(arr, new boolean[N + 1], 1, 0);
        System.out.println(ans);
    }

    private static void choose(int[] arr, int[] chosen, boolean[] selected, int count) {
        if (count == 4) {
            // 정답 갱신
            int sum = 0;
            for (int index : chosen) {
                sum += arr[index];
                if (sum > M) {
                    return;
                }
            }

            if (sum <= M && ans < sum) {
                ans = sum;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                chosen[count] = i;
                choose(arr, chosen, selected, count + 1);
                chosen[count] = 0;
                selected[i] = false;
            }
        }
    }

    private static void bruteForce(int[] arr, boolean[] selected, int k, int sum) {
        if (k == 4) {
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!selected[i]) {
                if (sum + arr[i] <= M) {
                    selected[i] = true;
                    bruteForce(arr, selected, k + 1, sum + arr[i]);
                    selected[i] = false;
                }
            }
        }
    }
}
