package inflearn.ch03_twopointer_slidingwindow;

import java.util.Scanner;

/**
 * 1. 두 배열 합치기
 * 설명
 *
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 *
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 *
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 *
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 *
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 */

import java.util.*;

public class ConcatArrayTwoPointers {

    public static void main(String[] args) {
        ConcatArrayTwoPointers main = new ConcatArrayTwoPointers();
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int[] arr1 = new int[num1];

        for (int i = 0; i < num1; i++) {
            arr1[i] = sc.nextInt();
        }

        int num2 = sc.nextInt();
        int[] arr2 = new int[num2];

        for (int i = 0; i < num2; i++) {
            arr2[i] = sc.nextInt();
        }

        for (int x : main.solution(num1, arr1, num2, arr2)) {
            System.out.print(x + " ");
        }
    }

    public List<Integer> solution(int n1, int[] arr1, int n2, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0, p2 = 0;

        while ((p1 < n1) && (p2 < n2)) {
            if(arr1[p1] < arr2[p2]) answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while(p1 < n1) answer.add(arr1[p1++]);
        while(p2 < n2) answer.add(arr2[p2++]);
        return answer;
    }
}
