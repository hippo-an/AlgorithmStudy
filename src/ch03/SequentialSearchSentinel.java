package ch03;

import java.util.Scanner;

public class SequentialSearchSentinel {

    static int seqSearchSentinel1(int[] a, int n, int key) {
        int i = 0;
        a[n] = key;

        while (true) {
            if (a[i] == key) {
                break;
            }
            i++;
        }
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");

        int num = sc.nextInt();
        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }
        System.out.print("검색할 값 : ");
        int key = sc.nextInt();

//        int idx = seqSearchSentinel1(x, num, key);
        int idx = seqSearchSentinel2(x, num, key);

        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("x[" + idx + "] 에 값이 있습니다.");
        }
    }

    private static int seqSearchSentinel2(int[] a, int num, int key) {
        int i;
        a[num] = key;

        for (i = 0; a[i] != key; i++)
            ;
        return i == num ? -1 : i;
    }
}
