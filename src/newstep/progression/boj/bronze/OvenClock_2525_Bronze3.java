package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OvenClock_2525_Bronze3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int cookTime = Integer.parseInt(br.readLine());
        int total = hour * 60 + minute + cookTime;

        if (total >= 24 * 60) {
            total -= 24 * 60;
        }

        System.out.printf("%d %d", total / 60, total % 60);
        br.close();

    }

}
