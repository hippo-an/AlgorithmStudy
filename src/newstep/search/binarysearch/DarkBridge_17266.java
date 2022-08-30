package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DarkBridge_17266 {

    private static int N, M;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[M + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = 1, R = N, ans = N;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else L = mid + 1;
        }

        System.out.println(ans);
    }

    private static boolean determination(int mid) {
        int last = 0;  // 밝혀진 마지막 위치
        for (int i = 1; i <= M; i++) {
            if (arr[i] - last <= mid) {
                last = arr[i] + mid;
            } else {
                return false;
            }
        }
        return last >= N;
    }
}
