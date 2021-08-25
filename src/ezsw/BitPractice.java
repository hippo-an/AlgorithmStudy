package ezsw;

import java.util.Scanner;

public class BitPractice {
    static int n;
    static int[] arr = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();

        System.out.println(solve());

    }

    private static int solve() {
        int ret = 0;

        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) != 2) continue;
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    sum += arr[j];
                }
            }
            if(sum == 7) ++ret;
        }

        return ret;
    }
}
