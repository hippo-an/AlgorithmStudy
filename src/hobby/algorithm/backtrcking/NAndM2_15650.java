package hobby.algorithm.backtrcking;

import java.io.*;
import java.util.StringTokenizer;

public class NAndM2_15650 {

    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m + 3];

        resolve(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

    static void resolve(int k, int prev) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = prev + 1; i <= n; i++) {
            selected[k] = i;
            resolve(k + 1, i);
            selected[k] = 0;
        }
    }
}
