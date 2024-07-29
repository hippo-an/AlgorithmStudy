package hobby.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxNumber_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int idx = -1;
        for (int i = 0; i < 9; i++) {
            int parse = Integer.parseInt(br.readLine());
            if (max <= parse) {
                max = parse;
                idx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
