package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IronBar_10799_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bars = br.readLine();
        int totalCount = 0;
        int count = 0;

        for (int i = 0; i < bars.length(); i++) {
            char c = bars.charAt(i);
            if (c == '(') {
                count++;
            } else {
                count--;
                if (bars.charAt(i - 1) == '(') {
                    totalCount += count;
                } else {
                    totalCount += 1;
                }
            }
        }

        System.out.println(totalCount);
        br.close();
    }
}
