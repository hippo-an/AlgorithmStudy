package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SystemTransformation_2745_Bronze2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int ans = 0;
        int from = N.length() - 1;
        for (int i = from; i >= 0; i--) {
            char c = N.charAt(i);
            if ('0' <= c && c <= '9') {
                ans += (c - '0') * (int) Math.pow(B, from - i);
            } else {
                ans += (c - 'A' + 10) * (int)Math.pow(B, from - i);
            }
        }

        System.out.println(ans);
        br.close();
    }
}
