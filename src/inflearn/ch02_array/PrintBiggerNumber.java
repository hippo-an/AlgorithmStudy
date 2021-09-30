package inflearn.ch02_array;

/**
 * 1. 큰 수 출력하기
 * 설명
 *
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 *
 * (첫 번째 수는 무조건 출력한다)
 *
 *
 * 입력
 * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 *
 *
 * 출력
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 */

import java.util.*;

public class PrintBiggerNumber {

    public static void main(String[] args) {
        PrintBiggerNumber main = new PrintBiggerNumber();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : main.solution(num, arr)) {
            System.out.print(x + " ");
        }
    }

    private List<Integer> solution(int num, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i = 1; i < num; i++) {
            if(arr[i] > arr[i - 1]) answer.add(arr[i]);
        }
        return answer;
    }
}
