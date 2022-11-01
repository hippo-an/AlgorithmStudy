package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EscapeFromRectangle_1085_Bronze3 {

    private static int x, y, w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int wMin = Math.min(Math.abs(w - x), x);
        int hMin = Math.min(Math.abs(h - y), y);

        System.out.println(Math.min(wMin, hMin));
    }
}
