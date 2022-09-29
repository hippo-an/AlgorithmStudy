package newstep.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SixDegreesOfKevinBacon_1389 {
    private static int N, M, x, y;
    private static StringTokenizer st;
    private static ArrayList<Integer>[] map;
    private static int[] dist;
    private static int[] ans;


    public static void main(String[] args) throws IOException {
        input();


        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int temp = Integer.MAX_VALUE, answer = 0;
        for (int i = 1; i <= N; i++) {
            if (ans[i] < temp) {
                temp = ans[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int start) {

        for (int i = 1; i <= N; i++) dist[i] = -1;

        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        dist[start] = 0;

        while (!Q.isEmpty()) {
            Integer poll = Q.poll();
            ans[start] += dist[poll];

            for (int x : map[poll]) {
                if (dist[x] != -1) continue;
                Q.add(x);
                dist[x] = dist[poll] + 1;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            map[x].add(y);
            map[y].add(x);
        }

        dist = new int[N + 1];
        ans = new int[N + 1];
    }
}
