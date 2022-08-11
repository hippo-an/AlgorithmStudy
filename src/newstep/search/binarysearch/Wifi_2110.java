package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Wifi_2110 {

    private static int N, C, L, R, ans;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        for ( int i = 1; i  <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, N + 1);

        L = 1; R = 1_000_000_000; ans = 0;

        while (L <= R) {
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
        int last = arr[1];
        int temp = 1;
        for (int i = 2; i <= N; i++) {
            if (arr[i] - last >= t) {
                last = arr[i];
                temp++;
            }
        }
        return temp >= C;
    }
}
