package inflearn.ch01_string;

/**
 * 
 * 4. 문자 뒤집기
 * 설명
 *
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 */

import java.util.*;

public class FlipTheWord {

    public static void main(String[] args) {

        FlipTheWord main = new FlipTheWord();
        Scanner sc = new Scanner(System.in);

        String[] strArray = new String[sc.nextInt()];

        for(int i = 0; i < strArray.length; i++) {
            strArray[i] = sc.next();
        }

        for(String x : main.solution(strArray)) {
            System.out.println(x);
        }
    }


    public List<String> solution(String[] strArray){
        List<String> answer = new ArrayList<>();

//        for (String x : strArray) {
//            String temp = new StringBuilder(x).reverse().toString();
//            answer.add(temp);
//        }

        for (String x : strArray) {
            char[] s = x.toCharArray();
            int lt = 0, rt = x.length() - 1;

            while (lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;

                lt++;
                rt--;
            }
            answer.add(String.valueOf(s));
        }
        return answer;
    }
}
