package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CalculateFamily_2644 {

    private static int N, from, to, M;
    private static List<Integer>[] family ;
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        from = Integer.parseInt(s[0]);
        to = Integer.parseInt(s[1]);

        M = Integer.parseInt(br.readLine());

        family = new ArrayList[N  + 1];

        for (int i = 1; i <= N; i++) {
            family[i] = new ArrayList<>();
        }


        while (M-- > 0) {
            s = br.readLine().split(" ");

            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            family[x].add(y);
            family[y].add(x);
        }

        dist = new int[N + 1];

        bfs();

        System.out.println(dist[to]);
    }

    private static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) dist[i] = -1;
        Q.add(from);
        dist[from] = 0;

        while (!Q.isEmpty()) {
            from = Q.poll();

            for (int x : family[from]) {
                if (dist[x] != -1) continue;
                Q.add(x);
                dist[x] = dist[from] + 1;
            }
        }
    }
}
