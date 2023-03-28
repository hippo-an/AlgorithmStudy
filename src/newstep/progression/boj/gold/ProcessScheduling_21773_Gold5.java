package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProcessScheduling_21773_Gold5 {

    private static int T;
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        PriorityQueue<Process> pq = new PriorityQueue<>(
            (p1, p2) -> {
                if (p1.priority == p2.priority) {
                    return p1.id - p2.id;
                }
                return p2.priority - p1.priority;
            }
        );

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int priority = Integer.parseInt(st.nextToken());

            Process process = new Process(id, time, priority + T);
            pq.offer(process);
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty() && T-- > 0) {
            Process poll = pq.poll();
            sb.append(poll.id).append("\n");
            poll.reduce();

            if (poll.time != 0) {
                pq.offer(poll);
            }
        }

        System.out.println(sb);
        br.close();
    }

    static class Process {
        int id;
        int time;
        int priority;

        public Process(int id, int time, int priority) {
            this.id = id;
            this.time = time;
            this.priority = priority;
        }

        public void reduce() {
            this.time--;
            this.priority--;
        }
    }
}
