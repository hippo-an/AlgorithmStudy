package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FashionKing_9375_Silver3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = null;
            Map<String, Integer> closet = new HashMap<>();
            for (int i = 1;i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();
                int cnt = closet.getOrDefault(category, 0);
                closet.put(category, cnt + 1);
            }

            int res = 1;
            for (Integer x : closet.values()) {
                res *= (x + 1);
            }
            sb.append(res - 1).append("\n");
        }

        System.out.println(sb);
    }
}
