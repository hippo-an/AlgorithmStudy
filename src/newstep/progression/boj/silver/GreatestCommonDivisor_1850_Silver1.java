package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GreatestCommonDivisor_1850_Silver1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long gcd = gcd(Math.max(x, y), Math.min(x, y));
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= gcd; i++) sb.append("1");

        System.out.println(sb);
        br.close();
    }

    private static long gcd(long max, long min) {
        if (max % min == 0) {
            return min;
        }
        return gcd(min, max % min);
    }

}
