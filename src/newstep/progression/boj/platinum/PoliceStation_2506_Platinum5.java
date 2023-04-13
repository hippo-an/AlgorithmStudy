package newstep.progression.boj.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class PoliceStation_2506_Platinum5 {

    private static int n, cnt;
    private static int[] costs, d;
    private static boolean finished[];
    private static Stack<Integer> s = new Stack<>();
    private static List<List<Integer>> graph = new ArrayList<>();
    private static List<List<Integer>> scc = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        costs = new int[n + 1];
        d = new int[n + 1];
        finished = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                int c = s.charAt(j - 1) - '0';

                if (c == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (d[i] == 0) {
                dfs(i);
            }
        }

        int ans = 0;

        for (int i = 0; i < scc.size(); i++) {
            List<Integer> sccList = scc.get(i);
            int temp = Integer.MAX_VALUE;
            for (Integer e : sccList) {
                temp = Math.min(temp, costs[e]);
            }
            ans += temp;
        }

        System.out.println(ans);

        br.close();
    }

    private static int dfs(int n) {
        d[n] = ++cnt;
        int lowLink = d[n];
        s.push(n);

        List<Integer> edges = graph.get(n);
        for (Integer e : edges) {
            if (d[e] == 0) {
                lowLink = Math.min(lowLink, dfs(e));
            } else if (!finished[e]) {
                lowLink = Math.min(lowLink, d[e]);
            }
        }

        if (lowLink == d[n]) {
            List<Integer> sc = new ArrayList<>();
            while (true) {
                int t = s.pop();
                sc.add(t);
                finished[t] = true;
                if (t == n) {
                    break;
                }
            }
            scc.add(sc);
        }

        return lowLink;
    }

}
