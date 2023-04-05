package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CycleGame_20040_Gold4 {

    private static int n, m;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int p1 = find(a);
            int p2 = find(b);

            if (p1 != p2) {
                union(p1, p2);
            } else {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
        br.close();
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return find(parent[a]);
    }

    private static void union(int a, int b) {
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

}
