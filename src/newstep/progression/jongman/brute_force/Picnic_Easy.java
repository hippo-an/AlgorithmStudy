package newstep.progression.jongman.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Picnic_Easy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            boolean[][] friendBoard = new boolean[n][n];
            boolean[] make = new boolean[n];

            while (st.hasMoreTokens()) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                friendBoard[a][b] = true;
                friendBoard[b][a] = true;
            }

            int ans = recursiveHelper(friendBoard, make);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int recursiveHelper(boolean[][] friendBoard, boolean[] make) {

        int free = -1;
        // 특정 형태의 답만 셀 수 있도록 하는 조건 -> 가장 빠른 번호 고르기
        for (int i = 0; i < make.length; i++) {
            if (!make[i]) {
                free = i;
                break;
            }
        }

        if (free == -1) {
            return 1;
        }

        int ret = 0;
        for (int i = free + 1; i < make.length; i++) {
            if (!make[i] && friendBoard[free][i]) {
                make[free] = true;
                make[i] = true;
                ret += recursiveHelper(friendBoard, make);
                make[free] = false;
                make[i] = false;
            }
        }

        return ret;
    }
}
