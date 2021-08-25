package ch06;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("버블 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        bubbleSortV5(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }


    // n 개의 요소수를 가지고 있는 a 배열
    private static void bubbleSortV1(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }

    // 버블정렬 v2 - 한 패스의 요소 교환 횟수가 0인 경우 정렬 요소가 없다는 뜻 = 이미 정렬이 완료. 작업을 멈춰도 됨.
    private static void bubbleSortV2(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;  // 패스당 요소 교환 횟수를 확인한다.
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                }
            }
            // 멈춤 확인
            if (exchg == 0) {
                break;
            }
        }
    }

    // 버블정렬 v3 - 각 패스내에서 일정 시점 이후 교환 수행이 없는 경우 그 앞쪽 요소는 이미 정렬을 마친 상태
    private static void bubbleSortV3(int[] a, int n) {
        int k = 0;
        while (k < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j > k; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }

    // 버블정렬 v4 - 홀수번 패스는 가장 작은 요소를 맨 앞으로, 짝수번 패스는 가장 큰 요소를 맨 뒤로 옮기는 방식
    // 양방향 버블 정렬, 칵테일 정렬, 셰이커 정렬
    private static void bubbleSortV4(int[] a, int n) {
        int left = 0;
        int right = n - 1;
        int last = right;

        while (left < right) {
            for (int j = right; j > left; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            left = last;

            for (int j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    last = j;
                }
            }
            right = last;
        }
    }

    static void bubbleSortV5(int[] a, int n) {
        int ccnt = 0; // 비교횟수
        int scnt = 0; // 교환횟수

        for (int i = 0; i < n - 1; i++) {
            System.out.printf("패스%d：\n", i + 1);
            for (int j = n - 1; j > i; j--) {
                for (int m = 0; m < n - 1; m++)
                    System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
                System.out.printf("%3d\n", a[n - 1]);

                ccnt++;
                if (a[j - 1] > a[j]) {
                    scnt++;
                    swap(a, j - 1, j);
                }
            }
            for (int m = 0; m < n; m++)
                System.out.printf("%3d  ", a[m]);
            System.out.println();
        }
        System.out.println("비교를 " + ccnt + "회 했습니다.");
        System.out.println("교환를 " + scnt + "회 했습니다.");
    }

    private static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
}
