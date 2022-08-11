package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IDontKnowWhoYouAre_1764 {

    private static int N, M, CNT = 0;
    private static String[] nrr, mrr;

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nrr = new String[N + 1];
        mrr = new String[M + 1];

        for (int i = 1; i <= N; i ++) {
            nrr[i] = br.readLine();
        }

        for (int i = 1; i <= M; i ++) {
            mrr[i] = br.readLine();
        }

        Arrays.sort(nrr, 1, N + 1);
        Arrays.sort(mrr , 1, M + 1);

        for (int i = 1; i <= N; i++) {
            int ret = Arrays.binarySearch(mrr, 1, M + 1, nrr[i]);
            if (ret >= 0) {
                CNT++;
                sb.append(nrr[i]).append("\n");
            }
        }
        System.out.println(CNT);
        System.out.println(sb.toString());
    }
}
