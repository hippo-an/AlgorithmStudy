package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi_11729_Silver1 {

    private static int ans = 0;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        move(cnt, 1, 3);

        System.out.println(ans);
        System.out.println(sb.toString());

        br.close();
    }

    private static void move(int num, int from, int to) {
        if (num > 1) {
            move(num - 1, from, 6 - from - to);
        }

        ans++;
        sb.append(from).append(" ").append(to).append("\n");

        if (num > 1) {
            move(num - 1, 6 - from - to, to);
        }
    }

}
