package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuffixArray_11656_Silver4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] dic = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            dic[i] = s.substring(i);
        }

        Arrays.sort(dic);

        StringBuilder sb = new StringBuilder();
        for (String suffix : dic) {
            sb.append(suffix).append("\n");

        }

        System.out.println(sb);
    }
}
