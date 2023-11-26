package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class One_4375_3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int cnt = 1;
            int base = 1;

            while ((base = base % n) != 0) {
                cnt++;
                base = base * 10 + 1;
            }
            sb.append(cnt).append('\n');
        }

        System.out.println(sb);

        br.close();
    }

}