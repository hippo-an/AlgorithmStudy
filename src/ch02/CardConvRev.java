package ch02;

import java.util.Scanner;

public class CardConvRev {
    static int cardConvR(int x, int r, char[] d) {
        int digits = 0;

        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        return digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int no;
        int cd;
        int dno;
        String retry;
        char[] cno = new char[32];

        System.out.println("10 진수를 기수 변환합니다.");

        do {

            do {
                System.out.print("변환할 음의 아닌 정수 : ");
                no = sc.nextInt();
            } while (no < 0);

            do {
                System.out.print("어떤 진수로 변환 할까요? (2~36) : ");
                cd = sc.nextInt();
            } while (cd < 2 || cd > 36);

            dno = cardConvR(no, cd, cno);

            System.out.print(cd + "진수로는");
            for (int i = dno - 1; i >= 0; i--) {
                System.out.print(cno[i]);
            }
            System.out.print("입니다.");

            System.out.println("한번 더 할까? [Y/N] : ");
            retry = sc.next();
        } while ("1".equals(retry) || "Y".equals(retry));
    }

    static int cardConv(int x, int r, char[] d) {
        int digits = 0;

        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        return digits;
    }
}
