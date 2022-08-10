package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TreeCutting_2805 {

    private static int N, M;
    private static long L, R;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, N + 1);

        L = arr[1];
        R = arr[N];
        long result = arr[N];
        if (R == 0) result = 0;
        else {
            outer:
            while (L <= R) {
                long mid = (L + R) / 2;
                long tempSum = 0;
                for (int i = N; i >= 1; i--) {
                    if (arr[i] > mid) {
                        tempSum += (arr[i] - mid);
                    }

                    if (tempSum > M) {
                        L = mid;
                        continue outer;
                    }
                }

                if (tempSum == M) {
                    result = mid;
                    break;
                } else {
                    R = mid;
                }
            }
        }


        System.out.println(result);
    }

}
