package hobby.datastructure.stack;

import java.io.*;
import java.util.Stack;

public class PValue_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int num = 1;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                num *= 2;
            } else if (c == '[') {
                stack.push(c);
                num *= 3;
            } else if (c == ')') {
                // stack 의 검증을 for 문을 돌면서 검증한다.
                if (stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }

                // peek 가 아닌 이전 인덱스의 값으로 정한다.
                // 2 와 3 을 곱하면서 num 을 쌓아가다가 첫번쨰 닫힘 괄호에서 값을 더한다.
                // stack 의 peek 가 아닌 이전 인덱스를 사용하는 방법을 잘 기억하자.
                if(s.charAt(i - 1)== '(') {
                    sum += num;
                }
                stack.pop();
                num /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
                if(s.charAt(i - 1)== '[') {
                    sum += num;
                }
                stack.pop();
                num /= 3;
            }
        }

        if (flag && stack.isEmpty()) {
            bw.write(String.valueOf(sum));
        } else {
            bw.write(String.valueOf(0));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
/*
* () 혹은 [] 가 몇점인가는 중첩되어 있는 소괄호와 대괄호의 열림 괄호로 계산하며
* num 변수를 활용하여 열림과 닫힘에 대해서 num 의 값을 곱하고 나눈다.
* */
