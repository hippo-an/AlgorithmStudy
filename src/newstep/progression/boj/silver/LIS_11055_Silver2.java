package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LIS_11055_Silver2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];
        int[] dy = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dy[i] = arr[i];
        }

        for (int i = 1; i <= N; i++) {
            for (int k = 0; k < i; k++) {
                if (arr[i] > arr[k] && dy[i] <= dy[k] + arr[i]) {
                    dy[i] = dy[k] + arr[i];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1;i <= N;i ++) {
            max = Math.max(max, dy[i]);
        }
        System.out.println(max);
    }
}
