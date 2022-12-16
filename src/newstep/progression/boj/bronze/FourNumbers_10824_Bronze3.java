package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FourNumbers_10824_Bronze3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken() + st.nextToken());
        long y = Long.parseLong(st.nextToken() + st.nextToken());

        System.out.println(x + y);
        br.close();
    }
}
