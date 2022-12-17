package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS_11722_Silver2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dy = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 재귀
//        for (int i = N; i >= 1; i--) {
//            recursiveLDS(arr, dy, N, i);
//        }

        // 반복 - 뒤에서 부터 현재 인덱스 보다 큰 인덱스의 값들에 대해 조건 비교후 동적 배열 채우기
        for (int i = N; i >= 1; i--) {
            dy[i] = 1;
            for (int k = i + 1; k <= N ; k++) {
                if (arr[i] > arr[k]) {
                    dy[i] = Math.max(dy[i], dy[k] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dy[i]);
        }

        System.out.println(max);
        br.close();
    }

    private static int recursiveLDS(int[] arr, int[] dy, int N, int i) {

        if (dy[i] == 0) {
            dy[i] = 1;

            for (int k = i + 1; k <= N; k++) {
                if (arr[k] < arr[i]) {
                    dy[i] = Math.max(dy[i], recursiveLDS(arr, dy, N, k) + 1);
                }
            }
        }

        return dy[i];
    }
}
