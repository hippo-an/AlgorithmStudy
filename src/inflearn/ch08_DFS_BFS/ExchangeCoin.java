package inflearn.ch08_DFS_BFS;

/**
 * 5. 동전교환
 * 설명
 *
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 *
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 *
 * 입력
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
 *
 * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
 *
 *
 * 출력
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 */

import java.util.*;

public class ExchangeCoin {

    static int n, m, answer = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) {
        ExchangeCoin main = new ExchangeCoin();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        main.dfs(0, 0);

        System.out.println(answer);

    }

    private void dfs(int l, int sum) {
        if(sum > m) return ;
        if(l >= answer) return ;
        if (sum == m) {
            answer = Math.min(answer, l);
        } else {
            for (int i = n-1; i >= 0; i--) {
                dfs(l + 1, sum + arr[i]);
            }
        }
    }
}
