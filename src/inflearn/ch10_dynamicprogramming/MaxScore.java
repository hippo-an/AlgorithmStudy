package inflearn.ch10_dynamicprogramming;

/**
 * 최대점수 구하기(냅색 알고리즘)
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를
 * 풀려고 합니다. 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩
 * 니다. 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다. (해당문제는
 * 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 * ▣ 입력설명
 * 첫 번째 줄에 문제의 개수N(1<=N<=50)과 제한 시간 M(10<=M<=300)이 주어집니다.
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 * ▣ 출력설명
 * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
 * ▣ 입력예제 1
 * 5 20
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 * ▣ 출력예제 1
 * 41
 */

import java.util.*;

public class MaxScore {

    public static void main(String[] args) {
        MaxScore main = new MaxScore();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Test> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Test(sc.nextInt(), sc.nextInt()));
        }

        System.out.println(main.solution(n, m, list));
    }

    private int solution(int n, int m, List<Test> list) {

        int[] dy = new int[m + 1];
        for (Test x : list) {
            for(int j = m; j >= x.t; j--) {
                dy[j] = Math.max(dy[j], dy[j - x.t] + x.s);
            }
        }
        return dy[m];
    }

    static class Test {
        int s, t;
        Test (int s, int t) {
            this.s = s;
            this.t = t;
        }

    }
}
