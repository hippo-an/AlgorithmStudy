package ch03;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int binarySearch(int[] a, int num, int key) {
        int pl = 0;
        int pr = num - 1;

        do {

            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                return pc;
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");

        int num = sc.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = sc.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = sc.nextInt();
            } while (x[i] < x[i - 1]);
        }


        System.out.print("검색할 값 : ");
        int key = sc.nextInt();

//        int idx = binarySearch(x, num, key);

        int idx = Arrays.binarySearch(x, key);

        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("x[" + idx + "] 에 값이 있습니다.");
        }
    }

    static int binarySearchX(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                for (; pc > pl; pc--) // key와 같은 맨 앞의 요소를 찾습니다
                    if (a[pc - 1] < key)
                        break;
                return pc; // 검색성공
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return -1;
    }
}
