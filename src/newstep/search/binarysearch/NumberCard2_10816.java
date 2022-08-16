package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard2_10816 {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, X;
    private static int[] nrr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nrr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            nrr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nrr, 1, N + 1);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            X = Integer.parseInt(st.nextToken());
            int upperBound = upperBound(nrr, 1, N, X);
            int lowerBound = lowerBound(nrr, 1, N, X);
            sb.append(upperBound - lowerBound).append(' ');
        }

        System.out.println(sb.toString());
    }

    private static int upperBound(int[] nrr, int L, int R, int X) {
        int ans = R + 1;

        while(L <= R) {
            int mid = (L + R) / 2;

            if (nrr[mid] > X) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return ans;
    }

    private static int lowerBound(int[] nrr, int L, int R, int X) {
        int ans = R + 1;

        while(L <= R) {
            int mid = (L + R) / 2;

            if (nrr[mid] >= X) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return ans;
    }
}
