package ch03;

import java.util.Scanner;

public class SequentialSearch {

    static int seqSearch1(int[] a, int n, int key) {
        int i = 0;

        while (true) {
            if (i == n) {
                return -1;
            }
            if (a[i] == key) {
                return i;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");

        int num = sc.nextInt();
        int[] x = new int[num];
        int[] y = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }
        System.out.print("검색할 값 : ");
        int key = sc.nextInt();

//        int idx = seqSearch1(x, num, key);

//        int idx = seqSearch2(x, num, key);

        int idx = seqSearchIdx(x, num, key, y);
        if (idx == 0) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(idx + "개의 요소가 있습니다.");
        }
    }

    private static int seqSearch2(int[] a, int num, int key) {
        for (int i = 0; i < num; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private static int seqSearchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                idx[count++] = i;
            }
        }
        return count;
    }
}
