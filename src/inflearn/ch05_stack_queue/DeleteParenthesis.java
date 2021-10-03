package inflearn.ch05_stack_queue;

/**
 * 2. 괄호문자제거
 * 설명
 *
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 남은 문자만 출력한다.
 */

import java.util.*;

public class DeleteParenthesis {

    public static void main(String[] args) {
        DeleteParenthesis main = new DeleteParenthesis();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(main.solution(str));


    }

    private String solution(String str) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if(x != ')') stack.push(x);
            else {
                while (stack.pop() != '(');
            }
        }
        for (char x : stack) {
            answer.append(x);
        }

        return answer.toString();
    }
}
