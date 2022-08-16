package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Budget_2512 {
    private static int N, M, max = Integer.MIN_VALUE, ans;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        M = Integer.parseInt(br.readLine());

        int L = 1;
        int R = max;

        while(L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean determination(int t) {
        int temp = 0;

        for (int i = 1; i <= N; i++) {
            temp += Math.min(arr[i], t);
            if (temp  > M) return false;
        }

        return temp <= M;
    }
}
