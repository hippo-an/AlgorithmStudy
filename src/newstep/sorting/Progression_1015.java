package newstep.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Progression_1015 {

    private static int N;
    private static Num[] A;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new Num[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            Num num = new Num(i, Integer.parseInt(st.nextToken()));
            A[i] = num;
        }

        Arrays.sort(A, 1, N + 1, Comparator.comparingInt(n -> n.val));

        for (int i = 1; i <= N; i++) {
            A[i].changed = i;
        }

        Arrays.sort(A, 1, N + 1, Comparator.comparingInt(n -> n.origin));

        for (int i = 1; i <= N; i++) {
            sb.append(A[i].changed - 1).append(" ");
        }

        System.out.println(sb.toString());

    }

    static class Num{
        int origin;
        int val;
        int changed;

        public Num(int origin, int val) {
            this.origin = origin;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Num{" +
                    "origin=" + origin +
                    ", val=" + val +
                    ", changed=" + changed +
                    '}';
        }
    }
}
