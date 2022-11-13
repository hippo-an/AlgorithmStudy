package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FindPassword_17219_Silver4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> pwdNote = new HashMap<>();
        while (N-- >0){
            st = new StringTokenizer(br.readLine());
            pwdNote.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0){
            sb.append(pwdNote.get(br.readLine()))
                    .append("\n");
        }

        System.out.println(sb);
    }
}
