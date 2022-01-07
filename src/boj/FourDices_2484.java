package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FourDices_2484 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        String cnt = br.readLine();
        for (int i = 0; i < Integer.parseInt(cnt); i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[4];
            int temp = 0;
            while (st.hasMoreTokens()) {
                arr[temp++] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if (arr[0]==arr[3]) temp = 50000 + arr[3] * 5000;
            else if (arr[1]==arr[2]) {
                if (arr[0]==arr[2] || arr[1]==arr[3]) temp = 10000 + arr[2] * 1000;
                else temp = 1000 + arr[2] * 100;
            }
            else if (arr[0]==arr[1]) {
                if (arr[2]==arr[3]) temp = 2000 + arr[1] * 500 + arr[3] * 500;
                else temp = 1000 + arr[1] * 100;
            } else if (arr[2]==arr[3]) temp = 1000 + arr[3] * 100;
            else temp = arr[3] * 100;
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }
}
