package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RepresentationOfASet_1717_Gold5 {

    public static final String YES = "YES";
    public static final String NO = "NO";
    private static int n, m;
    private static int[] parents, rank;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                union(a, b);
            } else {
                find(a, b);
            }
        }

        System.out.println(sb.toString());
        br.close();
    }

    private static void find(int a, int b) {
        if (find(a) == find(b)) {
            sb.append(YES).append("\n");
        } else {
            sb.append(NO).append("\n");
        }
    }

    private static int find(int node) {
        if (parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node]);
    }

    private static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if(p1 == p2) return;

        // rank 가 크다 -> root node
        if(rank[p1] < rank[p2]) {
            parents[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            parents[p2] = p1;
            rank[p1] += rank[p2];
        }
    }
}
