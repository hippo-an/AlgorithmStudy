package ch01;

import java.util.Scanner;

public class Q14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        do {
            System.out.println("양수를 입력해 주세요.");
            System.out.print("n = ");
            n = sc.nextInt();
        } while (!(n > 0));

        makeStarBox(n);
        System.out.println("=============================");
        spira(n);
    }

    private static void makeStarBox(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++)
                System.out.print(' ');
            for (int j = 1; j <= (i - 1) * 2 + 1; j++)
                System.out.print('*');
            System.out.println();
        }
    }
}
