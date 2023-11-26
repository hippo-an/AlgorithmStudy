package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoldbachConjecture_6588_1 {

    private static boolean[] notPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                for (int j = i + i; j < notPrime.length; j += i) {
                    notPrime[j] = true;
                }
            }
        }

        String s;
        StringBuilder sb = new StringBuilder();

        while (!"0".equals((s = br.readLine()))) {
            int origin = Integer.parseInt(s);

            boolean isPossible = false;
            for (int i = 2; i < origin / 2; i++) {
                if (!notPrime[i] && !notPrime[origin - i]) {
                    sb.append(origin)
                            .append(" = ")
                            .append(i)
                            .append(" + ")
                            .append(origin - i)
                            .append("\n");
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                sb.append("Goldbach's conjecture is wrong.")
                        .append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else if (number <= 3) {
            return true;
        } else if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (long i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
