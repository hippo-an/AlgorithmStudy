package hobby.algorithm.graph;

import java.io.*;
import java.util.*;

public class WormVirus_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            graph.get(u).add(p);
            graph.get(p).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v + 1];

        q.offer(1);
        visited[1] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Integer x : graph.get(cur)) {
                if (visited[x]) {
                    continue;
                }
                count++;
                q.offer(x);
                visited[x] = true;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
