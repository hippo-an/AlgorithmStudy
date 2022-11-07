package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimeNumberFinder_1929_Silver3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = N; i <= M; i++) {
            if (isPrime(i)) {
                sb.append(i)
                        .append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isPrime(int x) {
        for (int i = 2;i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return x != 1;
    }
}
