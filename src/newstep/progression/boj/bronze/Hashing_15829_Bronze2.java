package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hashing_15829_Bronze2 {
    public static final long M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long ans = 0;
        long pow = 1;

        for ( int i = 0; i < s.length(); i++) {
            ans += ((s.charAt(i) - 'a' + 1) * pow )% M;
            pow = (pow * 31) % M;
        }
        System.out.println(ans % M);
    }
}
