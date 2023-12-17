package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PreviousPermutation_10973_3 {
    private static int n;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (prev()) {
            StringBuilder sb = new StringBuilder();
            for (int a : arr) {
                sb.append(a)
                        .append(" ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }

        br.close();
    }

    private static boolean prev() {
        int x = arr.length - 1;

        // 뒤에서 부터 최대 내림차순 구간을 찾는다.
        while(x > 0 && arr[x - 1] <= arr[x]) {
            x--;
        }

        if (x == 0) {
            return false;
        }

        int y = x;
        // x - 1 과 y + 1과 비교해야 하는 이유
        while (y < n - 1 && arr[x-1] > arr[y + 1]) {
            y++;
        }

        swap(x - 1, y);

        y = n - 1;
        while (x < y) {
            swap(x++, y--);
        }

        return true;
    }

    private static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
