package hobby.datastructure.maps;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Pika_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] pocket = new String[n + 1];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String p = br.readLine();
            pocket[i] = p;
            map.put(p, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= m; i++) {
            String p = br.readLine();
            if (Character.isAlphabetic(p.charAt(0))) {
                sb.append(map.get(p)).append("\n");
            } else if (Character.isDigit(p.charAt(0))) {
                sb.append(pocket[Integer.parseInt(p)]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
