package hobby.algorithm.tree;

import java.io.*;
import java.util.StringTokenizer;

public class TreeTraversal_1991 {
    private static char[] lc, rc;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        lc = new char[30];
        rc = new char[30];


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            if (l != '.') lc[a - 'A'] = l;
            if (r != '.') rc[a - 'A'] = r;
        }

        preOrder(0);
        bw.write("\n");
        inOrder(0);
        bw.write("\n");
        postOrder(0);

        bw.flush();
        bw.close();
        br.close();

    }

    private static void preOrder(int cur) throws IOException {
        bw.write('A' + cur);
        if (lc[cur] != 0) preOrder(lc[cur] - 'A');
        if (rc[cur] != 0) preOrder(rc[cur] - 'A');
    }

    private static void inOrder(int cur) throws IOException {
        if (lc[cur] != 0) inOrder(lc[cur] - 'A');
        bw.write('A' + cur);
        if (rc[cur] != 0) inOrder(rc[cur] - 'A');
    }

    private static void postOrder(int cur) throws IOException {
        if (lc[cur] != 0) postOrder(lc[cur] - 'A');
        if (rc[cur] != 0) postOrder(rc[cur] - 'A');
        bw.write('A' + cur);
    }
}
