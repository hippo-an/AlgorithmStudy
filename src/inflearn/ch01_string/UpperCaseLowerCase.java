package inflearn.ch01_string;


/**
 *
 * 2. 대소문자 변환
 * 설명
 *
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 *
 * 문자열은 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
 */

import java.util.*;

public class UpperCaseLowerCase {

    public static void main(String[] args) {

        UpperCaseLowerCase main = new UpperCaseLowerCase();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(main.solution(str));
    }


    public String solution(String str){
        StringBuilder sb = new StringBuilder();

        // 65 ~ 90 -> 대문자 아스키
        // 97 ~ 122 -> 소문자 아스키
        // 소문자 - 32 = 대문자 아스키
        for (char ch : str.toCharArray()) {
//            if(Character.isLowerCase(ch)) sb.append(Character.toUpperCase(ch));
//            else sb.append(Character.toLowerCase(ch));

            if(ch >= 97 && ch <= 122) sb.append((char)ch-32);
            else sb.append((char)ch+32);
        }
        return sb.toString();
    }
}
