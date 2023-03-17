package newstep.progression.hackerrank.preperation;

public class Staircase {

    public static void staircase(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(n - i - 1));
            sb.append("#".repeat(i + 1));
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
