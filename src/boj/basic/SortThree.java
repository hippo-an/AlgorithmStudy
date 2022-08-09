package boj.basic;

import java.io.*;
import java.util.*;

public class SortThree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer token = new StringTokenizer(s);

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
