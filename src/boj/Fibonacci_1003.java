package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] arrZero = new int[41];
        int[] arrOne = new int[41];

        arrZero[0] = 1;
        arrOne[1] = 1;

        for(int i = 2; i <= 40; i++) {
            arrZero[i] = arrZero[i-1] + arrZero[i-2];
            arrOne[i] = arrOne[i-1] + arrOne[i-2];
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arrZero[n])
                    .append(" ")
                    .append(arrOne[n])
                    .append("\n");
        }

        System.out.println(sb.toString());

    }
}
