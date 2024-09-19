package hobby.algorithm.backtrcking;

import java.io.*;
import java.util.StringTokenizer;

public class NAndM4_15652 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 4];

        resolve(0, 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void resolve(int k, int start) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]);
                sb.append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[k] = i;
            resolve(k + 1, i);
            arr[k] = 0;
        }

    }
}
