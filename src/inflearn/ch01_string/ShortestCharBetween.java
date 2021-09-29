package inflearn.ch01_string;

/**
 *
 * 10. 가장 짧은 문자거리
 * 설명
 *
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 *
 * 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 */

import java.util.*;

public class ShortestCharBetween {

    public static void main(String[] args) {

        ShortestCharBetween main = new ShortestCharBetween();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char check = sc.next().charAt(0);

        for (int x : main.solution(str, check)) {
            System.out.print(x + " ");
        }
    }


    public int[] solution(String str, char ch){
        int p = 1000, i;
        int len = str.length();
        int[] answer = new int[len];

        for (i = 0; i < len; i++) {
            if(str.charAt(i) == ch) {
                p = 0;
                answer[i] = p;
            } else  answer[i] = ++p;
        }

        p = 1000;
        for(i = len - 1; i >= 0; i--) {
            if(str.charAt(i) == ch) p = 0;
            else {
                answer[i] = Math.min(answer[i], ++p);
            }
        }

        return answer;
    }
}
