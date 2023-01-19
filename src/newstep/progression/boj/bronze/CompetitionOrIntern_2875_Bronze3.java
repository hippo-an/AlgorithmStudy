package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompetitionOrIntern_2875_Bronze3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        while (K > 0) {
            if (N / 2 >= M) {
                N--;
                K--;
            }  else {
                M--;
                K--;
            }
        }

        int ans = Math.min(N / 2, M);
        System.out.println(ans);
    }

}
