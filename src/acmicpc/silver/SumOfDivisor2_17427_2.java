package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDivisor2_17427_2 {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        long sum = 0L;
        // f(A) = A 의 모든 약수의 합
        // g(y) = f(1) + f(2) + ... + f(y)

        for (int i = 1; i <= n; i++) {
            sum += ((long) (n / i) * i);
        }

        System.out.println(sum);

        br.close();
    }
}
