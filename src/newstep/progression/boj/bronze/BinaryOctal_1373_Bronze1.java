package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryOctal_1373_Bronze1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int inputSize = input.length();
        int check = inputSize % 3;

        if (check == 1) {
            sb.append(input.charAt(0));
        }
        if (check == 2) {
            sb.append((input.charAt(0) - '0') * 2 + input.charAt(1) - '0');
        }
        for (int i = check; i < inputSize; i += 3) {
            sb.append((input.charAt(i) - '0') * 4
                    + (input.charAt(i + 1) - '0') * 2
                    + (input.charAt(i + 2) - '0')
            );
        }
        System.out.println(sb);

        br.close();
    }
}
