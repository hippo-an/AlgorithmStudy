package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DirectorShom_1436_Silver5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int from = 666;
        int count = 1;

        while(count != N) {
            from++;
            if (String.valueOf(from).contains("666")) count++;
        }

        System.out.println(from);
    }
}
