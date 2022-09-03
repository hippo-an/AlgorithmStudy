package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Progression_2559 {

    private static int N, K;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = 1, R = K + 1, ans = 0;

        for (int i = 1; i < R ; i++) {
            ans += arr[i];
        }
        int temp = ans;

        while(R <= N) {
            temp = temp - arr[L++] + arr[R++];
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);



//        int R = 0, sum = 0, ans = -100 * N;
//        for (int L = 1; L + K - 1 <= N; L++) {
//            // L - 1 을 구간에서 제외하기
//            sum -= arr[L - 1];
//
//            // R 을 옮길 수 있을 때 까지 옮기기
//            while (R + 1 <= L + K - 1)
//                sum += arr[++R];
//
//            // [L ... R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
//            ans = Math.max(ans, sum);
//        }
//        System.out.println(ans);
    }
}
