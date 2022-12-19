package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeastCommonMultiple_1934_Bronze1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(lcm(Math.max(x, y), Math.min(x, y)))
                    .append("\n");

        }

        System.out.println(sb);
        br.close();
    }

    static int lcm(int max, int min) {
        return (max * min) / gcd(max, min);
    }

    static int gcd(int max, int min) {
        if (max % min == 0) return min;
        return gcd(min, max % min);
    }
}
