package ch01;

import java.util.Scanner;

public class Q11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.println("양의 정수를 입력해 주세요");

        do {
            System.out.print("n = ");
            n = sc.nextInt();
        } while (n <= 0);

        System.out.println("해당 수는 " + getIntegerLength(n) + "자리입니다.");
    }

    private static int getIntegerLength(int n) {
        return ((int) Math.log10(n)) + 1;
    }
}
