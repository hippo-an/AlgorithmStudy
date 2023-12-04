package acmicpc.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// f(A) = A 의 모든 약수의 합
// g(y) = f(1) + f(2) + ... + f(y)
// 이 문제의 핵심은 약수를 구하는 방식이 배수의 개념으로 접근을 해야함
//
public class SumOfDivisor_17425_4 {
    private static int t, n;
    private static final long[] fx = new long[1000001];
    private static final long[] dp = new long[1000001];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 1; i < fx.length; i++) {
            for (int j = 1; i * j < fx.length; j++) {
                fx[i * j] += i;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1] + fx[i];
        }

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n])
                    .append("\n");
        }


        System.out.println(sb);

        br.close();
    }

    // log(n) -> 약수 접근 방식
    private static long sumOfDivisor(int n) {
        // n 의 약수의 합
        double sqrt = Math.sqrt(n);

        long sum = 0;
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                sum += i;
                int divide = n / i;

                if (i != divide) {
                    sum += divide;
                }
            }
        }

        return sum;
    }
}
