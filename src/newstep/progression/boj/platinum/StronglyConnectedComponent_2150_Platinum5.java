package newstep.progression.boj.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class StronglyConnectedComponent_2150_Platinum5 {

    private static int v, e, index = 0;
    private static int[] d;
    private static Stack<Integer> s = new Stack<>();
    private static List<List<Integer>> graph = new ArrayList<>();
    private static Queue<List<Integer>> scc = new PriorityQueue<>((e1, e2) -> e1.get(0) - e2.get(0));
    private static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        d = new int[v + 1];
        finished = new boolean[v + 1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        for (int i = 1; i <= v; i++) {
            if (d[i] == 0) {
                dfs(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(scc.size()).append("\n");

        while (!scc.isEmpty()) {
            List<Integer> sc = scc.poll();
            for (Integer component : sc) {
                sb.append(component).append(" ");
            }
            sb.append("-1").append("\n");
        }

        System.out.println(sb.toString());
        System.out.println(Arrays.toString(d));

        br.close();
    }

    private static int dfs(int v) {
        d[v] = ++index;
        int lowLink = d[v];
        s.push(v);

        List<Integer> edges = graph.get(v);

        for (int next : edges) {
            if (d[next] == 0) {
                lowLink = Math.min(lowLink, dfs(next));
            } else if (!finished[next]) {
                lowLink = Math.min(lowLink, d[next]);
            }
        }

        if (lowLink == d[v]) {
            List<Integer> sc = new ArrayList<>();
            while (true) {
                int top = s.pop();
                sc.add(top);
                finished[top] = true;
                if (top == v) {
                    break;
                }
            }
            Collections.sort(sc);
            scc.add(sc);
        }

        return lowLink;
    }

}
