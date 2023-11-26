package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldbachPartition_17103_2 {

    private static final boolean[] notPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i < notPrime.length; i++) {
            if (notPrime[i]) {
                continue;
            }

            for (int j = i + i; j < notPrime.length; j += i) {
                notPrime[j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // not prime => 0 ~ 1000000
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());

            int cnt = 0;

            // j => 2 ~ 500000
            for (int j = 2; j <= n / 2; j++) {
                if (!notPrime[j] && !notPrime[n - j]) {
                    cnt++;
                }
            }

            sb.append(cnt)
                    .append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
