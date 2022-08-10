package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoLiquid_2470 {

    private static int N;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, N + 1);

        if (arr[1] > 0) sb.append(arr[1]).append(" ").append(arr[2]);
        else if (arr[N] < 0) sb.append(arr[N - 1]).append(" ").append(arr[N]);
        else {
            int min = Integer.MAX_VALUE;
            int L = 0, R = 0;
            for (int i =1; i < N; i++) {
                int result = lowerBound(arr, i + 1, N, -arr[i]);

                if (result <= N && Math.abs(arr[i] + arr[result]) < min) {
                    min = Math.abs(arr[i] + arr[result]);
                    L = arr[i];
                    R = arr[result];
                }

                if (result - 1 > i && Math.abs(arr[i] + arr[result - 1]) < min) {
                    min = Math.abs(arr[i] + arr[result - 1]);
                    L = arr[i];
                    R = arr[result - 1];
                }

            }
            sb.append(L).append(" ").append(R);
        }

        System.out.println(sb.toString());
    }

    private static int lowerBound(int[] arr, int L, int R, int T) {
        int result = R + 1;

        while(L <= R) {
            int mid = (L + R) / 2;

            if (arr[mid] < T) {
                L = mid + 1;
            } else {
                R = mid - 1;
                result = mid;
            }
        }

        return result;
    }
}
