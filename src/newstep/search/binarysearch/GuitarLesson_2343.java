package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GuitarLesson_2343 {

    private static int N, M;

    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = arr[1], R = 1000000000, ans = 0;
        for (int i = 1; i <= N; i++) L = Math.max(L, arr[i]);  // 적어도 제일 긴 녹화본의 길이 만큼은 필요하다! -> 요게 핵심이였네..

        while (L <= R) {
            int mid = (L + R) / 2;

            if (determination(mid)) {
                ans = mid;
                R = mid -1;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(ans);

    }

    private static boolean determination(int t) {
        int tempSum = 0;
        int cnt = 1;
        for (int i = 1; i <= N; i++) {
            if (tempSum + arr[i] > t) {
                cnt++;
                tempSum = arr[i];
            } else tempSum += arr[i];
        }
        return cnt <= M;
    }
}
