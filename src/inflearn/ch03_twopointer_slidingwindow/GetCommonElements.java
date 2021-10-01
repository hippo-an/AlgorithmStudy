package inflearn.ch03_twopointer_slidingwindow;
/**
 * 2. 공통원소 구하기
 * 설명
 *
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 *
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 *
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 *
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 *
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 *
 *
 * 출력
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 */

import java.util.*;

public class GetCommonElements {

    public static void main(String[] args) {
        GetCommonElements main = new GetCommonElements();
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

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while(p1 < n1 && p2 < n2) {
            if(arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1++]);
                p2++;
            } else if(arr1[p1] > arr2[p2]) p2++;
            else p1++;

        }
        return answer;
    }
}
