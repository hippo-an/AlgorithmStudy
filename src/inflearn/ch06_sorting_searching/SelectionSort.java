package inflearn.ch06_sorting_searching;
/**
 * 1. 선택 정렬
 * 설명
 *
 * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
 *
 * 정렬하는 방법은 선택정렬입니다.
 *
 *
 * 입력
 * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
 *
 * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
 *
 *
 * 출력
 * 오름차순으로 정렬된 수열을 출력합니다.
 */

import java.util.*;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort main = new SelectionSort();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : main.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    private int[] solution(int n, int[] arr) {
        // 2중 for 문을 사용하여 하나씩 선택해 정렬해 나간다.

        for(int i = 0; i < n -1; i++) {
            int idx = i;

            for (int j = i + 1; j < n; j++) {
                if(arr[j] < arr[idx]) idx = j;
            }

            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;

        }
        return arr;
    }
}
