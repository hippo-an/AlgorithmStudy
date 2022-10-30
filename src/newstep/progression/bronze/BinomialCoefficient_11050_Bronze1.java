package newstep.progression.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이항계수란 n 개에서 k개를 순서 없이 뽑는 조합의 가짓수를 의미한다.
 * 이항계수는 콤비네이션이라고도 하며
 * n! / (n - k)! / k! 으로 정의된다.
 *
 * 이항계수의 성질은
 * 1. nCk = nC(n-k) -> 선택받지 못할것은 선택한다는 개념으로 접근하면 된다
 * 2. nCk = (n-1)Ck + (n-1)C(k-1)
 *
 * 아래 메모이제이션(캐시)을 통한 문제풀이는 2번 성질을 확장해서
 *
 * nC0 = nCn = 1 을 통해 최소 조건의 수를 구한 후 작은 경우에서 큰경우로 확장해나간다.
 */
public class BinomialCoefficient_11050_Bronze1 {

    private static int[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        memo = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            memo[i][0] = 1;
            memo[i][i] = 1;
        }

        for (int i = 1; i <= N ;i++) {
            for (int j = 1; j <= K; j++) {
                memo[i][j] = memo[i - 1][j] + memo[i - 1][j - 1];
            }
        }

        System.out.println(memo[N][K]);
    }
}
