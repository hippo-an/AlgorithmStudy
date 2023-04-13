package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class NetworkConnection_1922_Gold4 {

    private static int n, m;
    private static int[] parents;
    private static Queue<Cable> network;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parents = new int[n + 1];
        network = new PriorityQueue<>(Comparator.comparingInt(c -> c.weight));

        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            network.add(new Cable(from, to, weight));
        }

        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        int ans = 0;
        while (!network.isEmpty()) {
            Cable c = network.poll();
            if (find(c.to) != find(c.from)) {
                union(c.to, c.from);
                ans += c.weight;
            }
        }

        System.out.println(ans);

        br.close();
    }

    private static void union(int to, int from) {
        int p1 = find(to);
        int p2 = find(from);

        if (p1 == p2) {
            return;
        }

        if (p1 < p2) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
        }
    }

    private static int find(int n) {
        if (parents[n] == n) {
            return parents[n];
        }
        return parents[n] = find(parents[n]);
    }

    private static class Cable {
        int from;
        int to;
        int weight;

        public Cable(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

}
