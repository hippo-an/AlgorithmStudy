package ch05;

import ch04.IntStack;

import java.util.Scanner;

public class Recur {
    static void recur1(int n) {
        if (n > 0) {
            recur1(n - 1);
            System.out.println(n);
            recur1(n - 2);
        }
    }

    static void recur2(int n) {
        while (n > 0) {
            recur2(n-1);
            System.out.println(n);
            n = n - 2;
        }
    }

    static void recur3(int n) {
        IntStack s = new IntStack(n);

        while (true) {
            if (n > 0) {
                s.push(n);
                n = n - 1;
                continue;
            }
            if (!s.isEmpty()) {
                n = s.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    static void recur4(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0)
                    n = n - 1;
                else if (sw == 1) {
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if (sw == 2) {
                    System.out.println(n);
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }

    static void recur5(int n) {
        if (n > 0) {
            recur5(n - 1);
            recur5(n - 2);
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = sc.nextInt();

        recur4(x);
    }
}
