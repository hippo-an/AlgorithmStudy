package hobby.algorithm.recursion;

import java.io.*;
import java.util.StringTokenizer;

public class Z_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int count = visit(r, c, n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int visit(int r, int c, int n) {
        if (n == 0) {
            return 0;
        }

        int h = 1 << (n - 1);

        if (r < h && c < h) return visit(r, c, n - 1);
        else if (r < h && c >= h) return h * h + visit(r, c - h, n - 1);
        else if (r >= h && c < h) return 2 * h * h + visit(r - h, c, n - 1);
        return 3 * h * h + visit(r - h, c - h, n - 1);
    }
}
