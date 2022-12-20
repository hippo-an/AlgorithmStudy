package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TenSplit_11721_Bronze3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        while (s.length() > 10) {
            sb.append(s, 0, 10)
                    .append("\n");

            s = s.substring(10);
        }
        sb.append(s);

        System.out.println(sb);
        br.close();

    }
}
