package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FactorialZero_1676_Silver5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigInteger n = BigInteger.ONE;

        for (int i = 1;i <= N; i++) {
            n = n.multiply(BigInteger.valueOf(i));
        }

        int cnt = 0;
        while (true) {
            BigInteger mod = n.mod(BigInteger.TEN);
            if (mod.equals(BigInteger.ZERO)) {
                cnt++;
            } else {
                break;
            }
            n = n.divide(BigInteger.TEN);
        }

        System.out.println(cnt);
    }
}
