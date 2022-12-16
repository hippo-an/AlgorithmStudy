package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ROT13_11665_Bronze1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                char newC = (char) (c + 13);

                if (Character.isLowerCase(c) && newC > 'z') {
                    newC -= 26;
                } else if (Character.isUpperCase(c) && newC > 'Z') {
                    newC -= 26;
                }

                sb.append(newC);

            } else {
                sb.append(c);
            }
        }

        System.out.println(sb);
    }
}
