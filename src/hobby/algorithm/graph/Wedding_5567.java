package hobby.algorithm.graph;

import java.io.*;
import java.util.*;

public class Wedding_5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[1] = true;
        int count = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer x : graph.get(cur)) {
                if (visited[x]) {
                    continue;
                }

                count++;
                visited[x] = true;
                if (cur == 1) {
                    queue.offer(x);
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
