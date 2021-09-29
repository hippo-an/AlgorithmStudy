package ezsw.basic2;

import java.util.Scanner;

public class Array1 {

    static int n;
    static int[] Score = new int[100];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; ++i) {
            Score[i] = sc.nextInt();
        }

        for (int i = 0; i < n; ++i) {
            System.out.print(Score[i] + " ");
        }

        System.out.println("===================");
    }
}
