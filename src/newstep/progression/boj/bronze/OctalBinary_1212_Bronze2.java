package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OctalBinary_1212_Bronze2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String binary = Integer.toBinaryString(s.charAt(i) - '0');
            if (i != 0) {
                if (binary.length() == 1) binary = "00" + binary;
                else if (binary.length() == 2) binary = "0" + binary;
            }

            sb.append(binary);
        }

        System.out.println(sb);
        br.close();
    }

}
