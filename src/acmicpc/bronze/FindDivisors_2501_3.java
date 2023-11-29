package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class FindDivisors_2501_3 {

    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        double sqrt = Math.sqrt(N);

        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                divisors.add(i);
                int divide = N / i;

                if (i != divide) {
                    divisors.add(divide);
                }
            }
        }

        Collections.sort(divisors);

        if (K - 1 >= divisors.size()) {
            System.out.println(0);
        } else {
            System.out.println(divisors.get(K - 1));
        }
    }
}
