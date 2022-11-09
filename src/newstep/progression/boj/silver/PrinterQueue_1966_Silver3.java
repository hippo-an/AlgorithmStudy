package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PrinterQueue_1966_Silver3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            Queue<Info> q = new LinkedList<>();

            for (int i = 0;i < x; i++) {
                q.offer(new Info(i, Integer.parseInt(st.nextToken())));
            }

            int cnt = 0;
            outer: while (true) {
                Info poll = q.poll();
                for (Info info : q) {
                    if (poll.score < info.score) {
                        q.offer(poll);
                        continue outer;
                    }
                }
                cnt++;
                if (poll.idx == idx) {
                    break;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static class Info {
        private int idx;
        private int score;

        Info(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }
}
