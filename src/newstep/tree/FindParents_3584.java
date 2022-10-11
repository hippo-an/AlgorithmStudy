package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FindParents_3584 {
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static List<Integer>[] child;
    private static StringTokenizer st;
    private static boolean[] flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            child = new ArrayList[N + 1];

            for (int i = 0; i <= N; i++) child[i] = new ArrayList<>();
            flag = new boolean[N + 1];

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int par = Integer.parseInt(st.nextToken());
                int chi = Integer.parseInt(st.nextToken());

                child[chi].add(par);
            }

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            findRoot(x1);
            findRoot(x2);
        }
        System.out.println(sb);

    }

    private static void findRoot(int x) {
        if (flag[x]) sb.append(x).append("\n");
        else {
            flag[x] = true;
            for (int y : child[x]) {
                findRoot(y);
            }
        }
    }
}
