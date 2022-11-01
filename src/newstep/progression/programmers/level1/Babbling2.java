package newstep.progression.programmers.level1;

public class Babbling2 {

    public static void main(String[] args) {
        Babbling2 a = new Babbling2();
        System.out.println(a.solution(new String[]{"ayaaaya", "yee", "u", "maa"}));
    }
    private static String[] base = {"aya", "ye", "woo", "ma" };

    public int solution(String[] babbling) {
        int answer = 0;
        for (String x : babbling) {
            if (x.contains(base[0] + base[0]) || x.contains(base[1] + base[1]) || x.contains(base[2] + base[2]) || x.contains(base[3] + base[3])) {
                continue;
            }


            x = x.replace(base[0], " ")
                    .replace(base[1], " ")
                    .replace(base[2], " ")
                    .replace(base[3], " ");

            if (x.trim().isEmpty()) answer++;
        }
        return answer;
    }
}
