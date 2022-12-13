package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlphabetCount_10808_Bronze4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] al = new int[26];
        for (int i = 0; i < s.length(); i++) {
            al[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int cnt : al) {
            sb.append(cnt)
                    .append(" ");
        }

        System.out.println(sb);
    }
}
