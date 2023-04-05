package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumSpanningTree_1197_Gold4 {

    private static int v, e;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.c));

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, c));
        }

        long sum = 0L;

        for (int i = 1; i <= e; i++) {
            Edge edge = edges.poll();
            int p1 = find(edge.a);
            int p2 = find(edge.b);

            if (p1 != p2) {
                if (p1 < p2) {
                    parent[p2] = p1;
                } else {
                    parent[p1] = p2;
                }

                sum += edge.c;
            }
        }

        System.out.println(sum);
        br.close();
    }

    private static int find(int n) {
        if (parent[n] == n) {
            return parent[n];
        }

        return parent[n] = find(parent[n]);
    }

    private static class Edge {
        int a;
        int b;
        int c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

}
