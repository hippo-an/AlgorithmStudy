package newstep.progression.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARightTriangle_4153_Bronze3 {

    private static long x, y, z;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            if (x == 0 && y == 0 && z == 0) break;
            long b = Math.max(x, Math.max(y, z));
            if ((x * x) + (y * y) + (z * z) == b * b * 2) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }
        System.out.println(sb);
    }
}
