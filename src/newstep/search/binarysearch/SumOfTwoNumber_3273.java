package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfTwoNumber_3273 {

    private static int N, X, ANS;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr, 1, N + 1);

        for (int i = 1; i < N; i++) {
            int target = Math.abs(arr[i] - X);

            int result = Arrays.binarySearch(arr, i + 1, N + 1, target);

            if (result > 0) {
                ANS++;
            }
        }

        System.out.println(ANS);
    }
}
