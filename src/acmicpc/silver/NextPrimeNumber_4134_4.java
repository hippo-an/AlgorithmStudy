package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextPrimeNumber_4134_4 {

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine());
            if (n == 0 || n == 1) {
                sb.append(2)
                        .append('\n');
                continue;
            }

            for (long i = n; ; i++) {
                if (isPrime(i)) {
                    sb.append(i)
                            .append('\n');
                    break;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isPrime(long number) {
        if(number <= 1) {
            return false;
        }else if(number <= 3) {
            return true;
        }else if(number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for(long i = 5; i * i <= number; i += 6) {
            if(number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
