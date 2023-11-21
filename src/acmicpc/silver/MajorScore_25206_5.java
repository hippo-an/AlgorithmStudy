package acmicpc.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MajorScore_25206_5 {

    private static Map<String, Double> scoreMap = new HashMap<>();

    public static void main(String[] args) throws IOException {

        scoreMap.put("A+", 4.5);
        scoreMap.put("A0", 4.0);
        scoreMap.put("B+", 3.5);
        scoreMap.put("B0", 3.0);
        scoreMap.put("C+", 2.5);
        scoreMap.put("C0", 2.0);
        scoreMap.put("D+", 1.5);
        scoreMap.put("D0", 1.0);
        scoreMap.put("F", 0.0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0.0;
        double count = 0.0;
        for (int i = 1; i <= 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double grade = Double.parseDouble(st.nextToken());
            String score = st.nextToken();
            if ("P".equals(score)) {
                continue;
            }
            count += grade;
            sum += (grade * scoreMap.get(score));
        }

        System.out.println(sum / count);

        br.close();
    }
}
