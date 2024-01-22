package acmicpc.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


// 문제 접근
// stack 에 들어가는 괄호의 값은 쌍을 맞추기 위해 사용하는 용도로 사용한다.
// sum 과 num 을 이용하여 곱과 합을 구한다.
// 여는 괄호를 만났을 경우 해당하는 수만큼 곱한다.
// 닫는 괄호를 만났을 경우 해당하는 수만큼 나눈다. -> 원상 복구
public class BracketsValue_2504_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();

        int sum = 0;
        int num = 1;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == '('){
                num *= 2;
                stack.push(c);
            }
            else if(c == '['){
                num *= 3;
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.empty() || stack.peek() != '('){
                    System.out.println(0);
                    return;
                }
                if(line.charAt(i - 1) == '(') {
                    sum += num;
                }
                stack.pop();
                num /= 2;
            }
            else{
                if(stack.empty() || stack.peek() != '['){
                    System.out.println(0);
                    return;
                }
                if(line.charAt(i - 1) == '[') sum += num;
                stack.pop();
                num /= 3;
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sum);
        } else {
            System.out.println(0);
        }

        br.close();
    }
}
