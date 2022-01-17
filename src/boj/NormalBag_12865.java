package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NormalBag_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] ret = new int[k + 1];

        for(int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            int w = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);

            for (int j = k; j >= w; j--) {
                ret[j] = Math.max(ret[j], ret[j - w] + v);
            }
        }
        System.out.println(ret[k]);
    }
}
