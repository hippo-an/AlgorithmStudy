package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RealEstateFight_20364 {

    private static int N, Q;
    private static boolean[] estate;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        estate = new boolean[N + 1];;

        for (int i = 1; i <= Q; i++) {
            int x = Integer.parseInt(br.readLine()), res = 0;
            int y = x;
            while (x > 0) {
                if (estate[x]) res = x;
                x >>= 1;
            }
            estate[y] = true;
            sb.append(res).append('\n');
        }

        System.out.println(sb);
    }
}
