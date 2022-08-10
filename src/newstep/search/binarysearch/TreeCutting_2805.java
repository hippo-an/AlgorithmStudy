package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TreeCutting_2805 {

    private static int N, M, L, R;
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

        L = 1; R = N;
        int result = arr[N] - 1;
        while (L < R) {
            int mid = (L + R) / 2;
            int bound = arr[mid];
            long sum = 0;
            for (int i = mid + 1; i <= R; i++) {
                sum += (arr[i] - bound);
            }

            if (sum < M) {
                R = mid;
            } else if (sum == M){
                result = arr[mid];
                break;
            } else {
                L = mid;
            }
        }

        System.out.println(result);
    }
}
