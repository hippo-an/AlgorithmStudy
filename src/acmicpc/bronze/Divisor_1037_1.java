package acmicpc.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Divisor_1037_1 {

    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(st.nextToken());
            if (s > max) {
                max = s;
            }
            
            if (s < min) {
                min = s;
            }
            
        }

        System.out.println(max * min);
        br.close();
    }
}