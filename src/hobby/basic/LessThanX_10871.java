package hobby.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LessThanX_10871 {

    private static int N;
    private static int X;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            if (X > Integer.parseInt(s[i])) {
                sb.append(s[i]).append(" ");
            }
        }

        System.out.println(sb.toString().trim());
    }
}
