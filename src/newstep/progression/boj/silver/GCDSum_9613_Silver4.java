package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCDSum_9613_Silver4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            int[] arr = new int[cnt + 1];

            for (int i = 1; i <= cnt; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;

            for (int i = 1; i < cnt; i++) {
                for (int k = i + 1; k <= cnt; k++) {
                    sum += gcd(Math.max(arr[i], arr[k]), Math.min(arr[i], arr[k]));
                }
            }

            sb.append(sum)
                    .append("\n");
        }

        System.out.println(sb);
        br.close();

    }

    private static long gcd(int max, int min) {
        if (max % min == 0) {
            return min;
        }
        return gcd(min, max % min);
    }
}
