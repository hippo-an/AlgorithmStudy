package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Blog_21921_Silver3 {

    private static int n, x;
    private static int[] graph;
    private static int sum = 0;
    private static int maxSum = 0;
    private static int cnt = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            graph[i] = Integer.parseInt(st.nextToken());
            if (i <= x) {
                sum += graph[i];
            }
        }

        slidingWindow();

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(cnt);
        }

    }

    private static void slidingWindow() {
        maxSum = sum;
        int l = 1;
        for (int r = x + 1; r <= n; r++) {
            sum = sum - graph[l] + graph[r];
            if (sum > maxSum) {
                maxSum = sum;
                cnt = 1;
            } else if (sum == maxSum) {
                cnt++;
            }
            l++;
        }

    }

}
