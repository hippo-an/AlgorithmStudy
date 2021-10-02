package inflearn.ch04_hashmap_treeset;

/**
 * 4. 모든 아나그램 찾기
 * 설명
 *
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 *
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 *
 * 입력
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 *
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 *
 * 출력
 * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
 */

import java.util.*;

public class FindAllAnagramHashTwoPointersSlidingWindow {

    public static void main(String[] args) {
        FindAllAnagramHashTwoPointersSlidingWindow main = new FindAllAnagramHashTwoPointersSlidingWindow();
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(main.solution(str1, str2));
    }

    private int solution(String str1, String str2) {
        int answer = 0;
        char[] arr = str1.toCharArray();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char x : str2.toCharArray()) {
            map2.put(x, map2.getOrDefault(x, 0) + 1);
        }

        for(int i = 0; i < str2.length() - 1; i++) {
            map1.put(arr[i], map1.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;

        for (int rt = str2.length() - 1; rt < arr.length; rt++) {
            map1.put(arr[rt], map1.getOrDefault(arr[rt], 0) + 1);

            if (map1.equals(map2)) {
                answer++;
            }

            map1.put(arr[lt], map1.get(arr[lt]) - 1);

            if(map1.get(arr[lt]) == 0) {
                map1.remove(arr[lt]);
            }

            lt++;

        }

        return answer;

    }
}
