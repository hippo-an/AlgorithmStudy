package newstep.progression.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RepeatableSequence_2331_Silver4 {


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> pocket = new ArrayList<>();

        int next = A;
        while (!pocket.contains(next)) {
            pocket.add(next);
            int temp = next;
            next = 0;
            while (temp != 0) {
                next += (int) Math.pow(temp % 10, P);
                temp /= 10;
            }
        }

        System.out.println(pocket.indexOf(next));
        br.close();
    }
}
