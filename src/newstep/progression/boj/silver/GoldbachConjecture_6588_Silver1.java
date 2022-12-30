package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GoldbachConjecture_6588_Silver1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        boolean[] nonePrime = new boolean[1000001];
        nonePrime[0] = nonePrime[1] = true;
        for (int i = 3; i * i <= 1000000; i += 2) {
            if (!nonePrime[i]) {
                for (int k = i * i; k <= 1000000; k += i) {
                    nonePrime[k] = true;
                }
            }
        }

        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            boolean flag = true;

            for (int i = 3; i * i <= 1000000; i+=2) {
                if (!nonePrime[i] && !nonePrime[n - i]) {
                    sb.append(String.format("%d = %d + %d\n", n, i, n - i));
                    flag = false;
                    break;
                }
            }

            if (flag) { sb.append("Goldbach's conjecture is wrong.\n");}
        }

        System.out.println(sb);
        br.close();

    }
}

