package newstep.progression.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class RecommendPSVersion1_21939_Gold4 {
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        TreeSet<Problem> problems = new TreeSet<>(
            (c1, c2) -> {
                if (c1.L == c2.L) {
                    return c2.P - c1.P;
                }
                return c2.L - c1.L;
            }
        );
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            Problem problem = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            problems.add(problem);
            map.put(problem.P, problem.L);
        }

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "recommend":
                    String level = st.nextToken();
                    if ("1".equals(level)) {
                        sb.append(problems.first().P).append("\n");
                    } else if ("-1".equals(level)) {
                        sb.append(problems.last().P).append("\n");
                    }
                    break;
                case "add":
                    Problem e = new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    problems.add(e);
                    map.put(e.P, e.L);
                    break;
                case "solved":
                    Integer p = Integer.parseInt(st.nextToken());
                    problems.remove(new Problem(p, map.get(p)));
                    map.remove(p);
                    break;
            }
        }

        System.out.println(sb);
        br.close();

    }

    static class Problem {
        public int P;
        public int L;

        public Problem(int p) {
            P = p;
        }

        public Problem(int p, int l) {
            P = p;
            L = l;
        }
    }

}
