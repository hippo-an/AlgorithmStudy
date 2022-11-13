package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PocketMonMaster_1620_Silver4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] pocketMonArr = new String[N + 1];
        Map<String, Integer> pocketMonBook = new HashMap<>();
        for (int i = 1;i <= N; i++) {
            String origin = br.readLine();
            pocketMonBook.putIfAbsent(origin, i);
            pocketMonArr[i] = origin;
        }

        StringBuilder sb = new StringBuilder();
        for (int i =1; i <= M;i ++) {
            String s = br.readLine();
            Integer idx = pocketMonBook.get(s);
            if (idx == null) {
                sb.append(pocketMonArr[Integer.parseInt(s)]).append("\n");
            } else {
                sb.append(idx).append("\n");
            }
        }
        System.out.println(sb);
    }
}
