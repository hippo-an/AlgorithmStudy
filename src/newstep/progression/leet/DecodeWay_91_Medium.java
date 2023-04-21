package newstep.progression.leet;

public class DecodeWay_91_Medium {
    public int numDecoding(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int length = s.length();
        int[][] dy = new int[3][length + 1];

        dy[1][1] = 1;
        dy[2][1] = 0;

        for (int i = 2; i <= length; i++) {
            dy[1][i] = dy[1][i - 1] + 1;
            dy[2][i] = dy[2][i - 1] + 1;
        }

        return dy[1][length] + dy[2][length];
    }
}
