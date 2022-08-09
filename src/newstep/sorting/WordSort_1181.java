package newstep.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class WordSort_1181 {

    private static int N;
    private static String[] arr;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, 1, N + 1,
                Comparator.comparing(String::length)
                        .thenComparing(String::compareTo)
        );

        sb = new StringBuilder(arr[1] + "\n");

        for (int i = 2; i <= N; i++) {
            if (arr[i].equals(arr[i - 1])) continue;
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

}
