package newstep.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Good_1253 {
    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, N + 1);

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (determination(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean determination(int idx) {

        int L = 1, R = N;

        while (L < R) {
            if (L == idx) {
                L ++;
                continue;
            } else if (R == idx) {
                R --;
                continue;
            }

            if (arr[L] + arr[R] == arr[idx]) {
                return true;
            } else if (arr[L] + arr[R] > arr[idx]) {
                R--;
            } else L++;
        }

        return false;
    }
}
