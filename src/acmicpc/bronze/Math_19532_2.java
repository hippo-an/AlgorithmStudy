package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_19532_2 {
    private static int a;
    private static int b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (isPossible(x, y)) {
                    sb.append(x)
                            .append(" ")
                            .append(y);
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean isPossible(int x, int y) {
        return a * x + b * y == c && d * x + e * y == f;
    }
}


