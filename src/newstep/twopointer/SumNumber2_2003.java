package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
4 2
1 1 1 1
3
10 5
1 2 3 4 2 5 3 1 1 2
3
 */
public class SumNumber2_2003 {

    private static int N, M;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // N^2
//        int ans1 = 0;
//        for (int i = 1; i <= N; i++) {
//            int sum = arr[i];
//            if (sum == M) {
//                ans1++;
//                continue;
//            }
//
//            for (int j = i  + 1; j <= N; j++) {
//                sum += arr[j];
//                if (sum == M) {
//                    ans1++;
//                    break;
//                }
//                else if (sum > M) {
//                    break;
//                }
//            }
//        }
//
//        System.out.println(ans1);

        // N

        int R = 0, ans2 = 0, sum = 0;

        for (int L = 1; L <= N; L ++) {
            // L - 1 구간 제외
            sum -= arr[L - 1];

            // R 을 옮길 수 있을 때까지 옮기기 - 전위 연산자로 들어가는 부분 확인
            while( R + 1 <= N && sum < M) {
                sum += arr[++R];
            }

            // 합이 조건에 맞는지 확인후 갱신
            if (sum == M) ans2++;
        }

        System.out.println(ans2);

    }
}
