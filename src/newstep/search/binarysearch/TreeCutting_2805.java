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


        L = 0; R = 1_000_000_000;
        int result = 0;
        outer:
        while (L <= R) {
            int mid = (L + R) / 2;

            if (determination(mid)) {L = mid + 1; result = mid;}
            else R = mid - 1;
        }


        System.out.println(result);
    }

    private static boolean determination(int target) {
        long tempSum = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] > target) {
                tempSum += (arr[i] - target);
            }
        }
        return tempSum >= M;
    }

}
