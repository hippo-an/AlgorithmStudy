package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InequalitySign_2529_1 {
    private static int k;
    private static String[] arr;
    private static boolean[] visited;
    private static boolean complete;
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new String[k];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken();
        }

        find("", 0, false);
        complete = false;
        find("", 0, true);
        System.out.println(sb);

        br.close();
    }

    // a < b 로 앞에서부터 하나씩 비교해서 찾아나가는 방식으로 모든 경우의 수를 다 비교할 수 있다.
    private static void find(String ans, int idx, boolean flag) {
        if (idx == k + 1) {
            sb.append(ans)
                    .append("\n");
            complete = true;
            return;
        }

        if (flag) {
            // 앞에서 부터 뒤로
            for (int j = 0; j < 10; j++) {
                if (complete) {
                    return;
                }
                if (visited[j]) {
                    continue;

                }
                if (idx == 0 || check(ans.charAt(idx - 1) - '0', arr[idx - 1], j)) {
                    visited[j] = true;
                    find(ans + j, idx + 1, flag);
                    visited[j] = false;
                }
            }
        } else {
            // 뒤에서 부터 앞으로
            for (int j = 9; j >= 0; j--) {
                if (complete) {
                    return;
                }
                if (visited[j]) {
                    continue;

                }
                if (idx == 0 || check(ans.charAt(idx - 1) - '0', arr[idx - 1], j)) {
                    visited[j] = true;
                    find(ans + j, idx + 1, flag);
                    visited[j] = false;
                }
            }
        }
    }


    private static boolean check(int oa, String op, int ob) {
        if ("<".equals(op)) {
            return oa < ob;
        }
        return oa > ob;
    }
}
