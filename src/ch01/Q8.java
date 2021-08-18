package ch01;

import java.util.Scanner;

public class Q8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1부터 입력한 수까지의 합을 구해드립니다.");

        System.out.print("n : ");
        int n = sc.nextInt();

        System.out.println("sum : " + sum(n));
    }

    private static int sum(int n) {
       return (n + 1) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0);
    }
}
