package newstep.progression.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 -> 에라토스테네스의 체를 이용한 소수 판별
 * 
 */
public class PrimeNumber_1978_Silver5 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        while (st.hasMoreTokens()) {
            if (isPrime(Integer.parseInt(st.nextToken()))) cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean isPrime(int n) {

        if (n == 1) return false;

        for (int i = 2;i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
