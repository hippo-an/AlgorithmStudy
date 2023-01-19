package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DisjoinAverage_21920_Silver4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        long ans = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (gcd(Math.max(arr[i], x), Math.min(arr[i], x)) == 1) {
                ans += arr[i];
                cnt++;
            }
        }

        System.out.printf("%.6f", (double)ans / cnt);
    }

    public static int gcd(int max, int min) {
        if (max % min == 0) {
            return min;
        }
        return gcd(min, max % min);
    }

}
