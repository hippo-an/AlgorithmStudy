package ch05;

public class QueenBB {
    static boolean[] flag = new boolean[8];
    static int[] pos = new int[8];

    public static void main(String[] args) {
        set(0);
    }

    private static void set(int col) {
        for (int row = 0; row < 8; row++) {
            if (!flag[row]) {
                pos[col] = row;
                if (col == 7) {
                    print();
                } else {
                    flag[row] = true;
                    set(col + 1);
                    flag[row] = false;
                }
            }
        }
    }

    private static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }
}
