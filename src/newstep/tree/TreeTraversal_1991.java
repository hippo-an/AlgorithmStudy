package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTraversal_1991 {
    private static int N;
    private static int[][] child;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        child = new int[26][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int current = st.nextToken().charAt(0) - 'A';

            for (int k = 0; k < 2; k++) {
                char sub = st.nextToken().charAt(0);
                if (sub != '.') child[current][k] = sub - 'A';
                else child[current][k] = -1;
            }
        }


        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        System.out.println(sb.toString());
    }

    private static void preOrder(int x) {
        if (x == -1) return;
        sb.append((char) (x + 'A'));
        preOrder(child[x][0]);
        preOrder(child[x][1]);
    }

    private static void inOrder(int x) {
        if (x == -1) return;
        inOrder(child[x][0]);
        sb.append((char) (x + 'A'));
        inOrder(child[x][1]);
    }

    private static void postOrder(int x) {
        if (x == -1) return;
        postOrder(child[x][0]);
        postOrder(child[x][1]);
        sb.append((char) (x + 'A'));
    }

}
