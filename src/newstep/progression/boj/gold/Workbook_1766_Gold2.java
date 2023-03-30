package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Workbook_1766_Gold2 {

    private static int N, M;
    private static int[] inDegree;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegree = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            inDegree[b]++;
            graph.get(a).add(b);
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            sb.append(poll).append(" ");

            for (Integer x : graph.get(poll)) {
                inDegree[x]--;
                if (inDegree[x] == 0) {
                    q.offer(x);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }

}
