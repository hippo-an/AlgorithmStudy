package inflearn.ch07_recursive_tree_graph;

/**
 * 재귀함수
 * 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.
 *
 * ▣ 입력설명
 * 첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.
 *
 * ▣ 출력설명
 * 첫째 줄에 출력한다.
 */

import java.util.*;

public class Recursive1 {
    public static void main(String[] args) {
        Recursive1 main = new Recursive1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 재귀 함수는 stack frame을 사용하기 때문에 제일 처음에 push 된 것은 제일 나중에 pop된다.
        // FILO - First In Last Out
        main.recursive(n);
    }

    private void recursive(int n) {
        if(n == 0) return ;
        else {
            System.out.print(n + " ");
            recursive(n - 1);
        }
    }

}
