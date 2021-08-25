package ezsw;

/**
 * 상대적으로 구현이 간단, 해가 존재하면 항상 찾게 된다.
 * 경우의 수에 따라 실행 시간이 비례하기 때문에 입력값의 범위가 작은 경우 유용
 */
public class BruteForce {
    /**
     * 경우의 수
     * - 순열(permutation)
     * >> - 선택 순서가 결과에 영향을 미치는 경우
     * - 조합(combination)
     * >> - 선택 순서가 결과에 영향을 주지 않는 경우
     * 
     * - 예제
     * >> -{1, 2, 3, 4}
     * >> 만들 수 있는 가장 큰 두 자리 수를 구하라 -> 순열
     * >> 두 수를 더했을 때 가장 큰 합을 구하라 -> 조합
     */

    static int n = 4;
    static int[] nums = {1, 2, 3, 4};

    public static void main(String[] args) {
        // 가장 큰 두 자리 수 구하기
        System.out.println(solve(0,0,0));


        // 가장 큰 두 수의 합 구하기
        System.out.println(solve1(0,0,0));
    }

    /**
     * 순열 예제 - 가장 큰 두 자리 수 구하기
     * @param cnt - 선택된 숫자의 갯수
     * @param used - 사용된 숫자
     * @param val - 중간 계산 결과
     * @return
     */
    static int solve(int cnt, int used, int val) {
        if(cnt == 2) return val;
        int ret = 0;

        for (int i = 0; i < n; i++) {
            if((used & 1<<i) != 0) continue;
            ret = Math.max(ret, solve(cnt + 1, used | 1 << i, val * 10 + nums[i]));
        }
        return ret;
    }

    /**
     * 조합 예제 - 가장 큰 두 수의 합 구하기
     * @param pos - 현재위치
     * @param cnt - 선택된 갯수
     * @param val - 중간 계산 결과
     * @return
     */
    static int solve1(int pos, int cnt, int val) {
        if(cnt == 2) return val;
        if(pos == n) return -1;

        int ret = 0;
        ret = Math.max(ret, solve1(pos + 1, cnt + 1, val + nums[pos]));
        ret = Math.max(ret, solve1(pos + 1, cnt, val));

        return ret;
    }

    static int sequentialSearch(int[] arr, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }


}
