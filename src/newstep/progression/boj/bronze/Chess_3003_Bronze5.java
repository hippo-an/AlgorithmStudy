package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chess_3003_Bronze5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] chess = new int[]{1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 6; i++) {
            sb.append(chess[i] - Integer.parseInt(st.nextToken())).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

}
