package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  dp 다이나믹 프로그래밍 동적 계획법
 */
public class MakeOne_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 3 == 0) arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            if (i % 2 == 0) arr[i] = Math.min(arr[i], arr[i / 2] + 1);
        }
        System.out.println(arr[n]);
        br.close();
    }
}
