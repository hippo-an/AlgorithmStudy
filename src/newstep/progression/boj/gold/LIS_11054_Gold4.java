package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS_11054_Gold4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dyLIS = new int[N + 1];
        int[] dyLDS = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 반복이 더 직관적인 느낌
        // 최장 증가 수열 구하기
        for (int i = 1;i <= N; i++) {
            dyLIS[i] = 1;
            for (int k = 1; k < i; k++) {
                if (arr[k] < arr[i]) {
                    dyLIS[i] = Math.max(dyLIS[i], dyLIS[k] + 1);
                }
            }
        }

        // 최장 감소 수열 구하기
        for (int i = N; i >= 1; i--) {
            dyLDS[i] = 1;
            for (int k = i + 1; k <= N; k++) {
                if (arr[k] < arr[i]) {
                    dyLDS[i] = Math.max(dyLDS[i], dyLDS[k] + 1);
                }
            }
        }

        // 최대 값 확인
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dyLIS[i] + dyLDS[i] - 1);
        }

        System.out.println(max);
        br.close();
    }
}
