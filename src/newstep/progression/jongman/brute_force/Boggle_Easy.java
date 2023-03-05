package newstep.progression.jongman.brute_force;

public class Boggle_Easy {

    private static char[][] board = {
        {'U', 'R', 'L', 'P', 'M'},
        {'X', 'P', 'R', 'E', 'T'},
        {'G', 'I', 'A', 'E', 'T'},
        {'X', 'T', 'N', 'Z', 'Y'},
        {'X', 'O', 'Q', 'R', 'S'}
    };

    public static void main(String[] args) {
        System.out.println(hasWord(1, 1, "PRETTY"));
        System.out.println(hasWord(2, 0, "GIRL"));
        System.out.println(hasWord(1, 2, "REPEAT"));
    }

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static boolean hasWord(int x, int y, String word) {
        // base case : 기저 사례
        int len = board.length - 1;
        if (y < 0 || x < 0 || y > len || x > len) {
            return false;
        }

        if (board[x][y] != word.charAt(0)) {
            return false;
        }

        if (word.length() == 1) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (hasWord(nx, ny, word.substring(1))) {
                return true;
            }
        }

        return false;
    }
}
