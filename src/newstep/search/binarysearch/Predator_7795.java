package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Predator_7795 {

    private static int N, M;
    private static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int t= 0; t < T; t++) {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);

            A = new int[N + 1];
            B = new int[M + 1];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B, 1, M + 1);

            int result = 0;
            for (int i = 1; i <= N; i++) {
                result += binarySearch(B, 1, M, A[i]);
            }

            System.out.println(result);
        }





    }

    private static int binarySearch(int[] arr, int L, int R, int t) {

        int result = L -1;

        while(L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] < t) {
                L = mid + 1;
                result = mid;
            } else {
                R = mid - 1;
            }

        }
        return result;
    }

}
