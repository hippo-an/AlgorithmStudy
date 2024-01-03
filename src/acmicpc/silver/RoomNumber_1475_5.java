package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RoomNumber_1475_5 {

    private static String s;

    private static final int[] arr = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        for (char c : s.toCharArray()) {
            arr[c - '0']++;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            ans = Math.max(ans, arr[i]);
        }

        System.out.println(Math.max(ans, (arr[6] + arr[9] + 1) / 2));
        br.close();
    }
}
