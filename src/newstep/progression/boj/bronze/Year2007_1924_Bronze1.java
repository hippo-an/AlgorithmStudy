package newstep.progression.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Year2007_1924_Bronze1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        int day = 0;
        int to = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i <= to; i++) {
            day += month[i];
        }
        day += Integer.parseInt(st.nextToken());

        if (day % 7 == 0) System.out.println("SUN");
        else if (day % 7 == 1) System.out.println("MON");
        else if (day % 7 == 2) System.out.println("TUE");
        else if (day % 7 == 3) System.out.println("WED");
        else if (day % 7 == 4) System.out.println("THU");
        else if (day % 7 == 5) System.out.println("FRI");
        else if (day % 7 == 6) System.out.println("SAT");

        br.close();
    }
}
