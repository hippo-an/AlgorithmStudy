package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CompanyCulture1_14267 {

    private static int N, M;
    private static List<Integer>[] child;
    private static int[] compliment;

    private static StringTokenizer st;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = nextInt(st.nextToken());
        M = nextInt(st.nextToken());

        child = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) child[i] = new ArrayList<>();
        compliment = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int x = nextInt(st.nextToken());
            if (x == -1) continue;
            child[x].add(i);
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = nextInt(st.nextToken());
            int w = nextInt(st.nextToken());

            compliment[i] += w;
        }

        dfs(1);

        for (int i = 1;i <= N; i++) {
            sb.append(compliment[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void dfs(int x) {
        for (int y : child[x]) {
            compliment[y] += compliment[x];
            dfs(y);
        }
    }


    private static int nextInt(String par) {
        return Integer.parseInt(par);
    }
}
