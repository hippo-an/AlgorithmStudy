package inflearn.ch08_DFS_BFS;

/**
 * 조합의 경우수(메모이제이션)
 *     
 *  로 계산합니다. 하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여
 * 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
 * 
 * 
 *     
 * ▣ 입력설명
 * 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
 * ▣ 출력설명
 * 첫째 줄에 조합수를 출력합니다.
 * ▣ 입력예제 1
 * 5 3
 * ▣ 출력예제 1
 * 10
 * ▣ 입력예제 2
 * 33 19
 * ▣ 출력예제 2
 * 818809200
 */

import java.util.*;

public class Combination {
    int[][] dy = new int[35][35];

    public static void main(String[] args) {
        Combination main = new Combination();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(main.dfs(n, r));
    }

    private int dfs(int n, int r) {
        if(dy[n][r] != 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else {
            return dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }

}
