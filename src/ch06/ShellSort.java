package ch06;

import java.util.Scanner;

public class ShellSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("셸 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        shellSortV2(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
    static void shellSortV1(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2) {
            System.out.println("h-정렬 : " + h + " ----------------");
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                }
                a[j + h] = tmp;
            }
        }
    }

    static void shellSortV2(int[] a, int n) {
        int h;
        for (h = 1; h < n / 9; h = h * 3 + 1) {
            ;
        }

        System.out.println("init h : " + h);

        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                System.out.println(">> i, a[i] : " + i + ", " + a[i]);
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                }
                System.out.println(">> j + h, a[j + h] : " + j + h + ", " + a[j + h]);
                a[j + h] = tmp;
                System.out.println(">> a[j + h] : " + a[j + h]);
            }

        }
    }
}
