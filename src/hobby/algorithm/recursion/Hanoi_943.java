package hobby.algorithm.recursion;

import java.io.*;

public class Hanoi_943 {
    private static StringBuilder sb = new StringBuilder();
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        move(1, 3, n);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void move(int a, int b, int n) throws IOException {
        count++;
        if (n == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }

        move(a, 6 - a - b, n - 1);
        sb.append(a).append(" ").append(b).append("\n");
        move(6 - a - b, b, n - 1);
    }
}
