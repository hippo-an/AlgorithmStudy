package newstep.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Card_11652 {
    private static int N;
    private static long[] arr = new long[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr, 1, N + 1);

        int temp = 1;
        int max = 1;
        long ans = arr[1];
        for (int i = 2; i <= N; i++) {
            if (arr[i] == arr[i - 1]) temp++;
            else temp = 1;

            if (temp > max) {
                max = temp;
                ans = arr[i - 1];
            }
        }

        System.out.println(ans);

    }




}
