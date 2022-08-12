package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard_10816 {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] nrr, mrr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nrr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            nrr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        mrr = new int[M + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            mrr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nrr, 1, N + 1);

        for (int i = 1; i <= M; i++) {
            int count = lowerBound(nrr, 1, N, mrr[i]);
            sb.append(count).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int lowerBound(int[] nrr, int L, int R, int X) {
        int cnt = 0;


        return cnt;
    }
}
