package inflearn.ch01_string;

/**
 * 7. 회문 문자열
 * 설명
 *
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 *
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *
 * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 *
 * 입력
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 */

import java.util.*;

public class Palindrome1 {

    public static void main(String[] args) {

        Palindrome1 main = new Palindrome1();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(main.solution(str));
    }


    public String solution(String str){

//        str = str.toUpperCase();
//        int lt = 0, rt = str.length() - 1;
//        while(lt < rt) {
//            if(str.charAt(lt) == str.charAt(rt)) {
//                lt++;
//                rt--;
//            } else return "NO";
//        }


//        str = str.toUpperCase();
//        int len = str.length();
//        for(int i = 0; i < len / 2 ; i++) {
//            if (str.charAt(i) != str.charAt(len - i - 1)) {
//                return "NO";
//            }
//        }

        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) return "YES";
        return "NO";

    }
}
