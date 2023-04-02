package newstep.progression.codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice {

    private static int n, k;
    private static int[] selected;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        selected = new int[k + 1];
        recursive(0);
        System.out.println(sb.toString());

        br.close();
    }

    private static void recursive(int idx) {
        if (idx == k) {
            for (int i = 0; i < k; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = n; i >= 1; i--) {
            selected[idx] = i;
            recursive(idx + 1);
            selected[idx] = 0;
        }
    }

}
