package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolvedAC_18110_4 {

    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        List<Integer> scores = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            scores.add(Integer.parseInt(br.readLine()));
        }
        br.close();

        Collections.sort(scores);

        long skip = Math.round(scores.size() * 0.15);
        int avg = getAverage(scores, (int) skip);
        System.out.println(avg);

    }

    private static int getAverage(List<Integer> scores, int skip) {
        int sum = 0;
        for (int i = skip; i < scores.size() - skip; i++) {
            sum += scores.get(i);
        }
        return (int) Math.round(sum / (n - 2.0 * skip));
    }
}
