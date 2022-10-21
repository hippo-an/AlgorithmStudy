package newstep.progression;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        long ans = x;
        for (int i = x - 1; i >= 1; i--) ans *= i;
        System.out.println(ans == 0 ? 1 : ans);
    }
}
