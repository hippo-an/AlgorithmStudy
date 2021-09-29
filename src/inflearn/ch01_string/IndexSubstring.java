package inflearn.ch01_string;

/**
 *3. 문장 속 단어
 * 설명
 *
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 *
 * 문장속의 각 단어는 공백으로 구분됩니다.
 *
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
 *
 * 단어를 답으로 합니다.
 *
 */

import java.util.*;

public class IndexSubstring {

    public static void main(String[] args) {

        IndexSubstring main = new IndexSubstring();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(main.solution(str));
    }


    public String solution(String str){
        String answer = "";
        int max = Integer.MIN_VALUE, pos;
//
//        String[] s = str.split(" ");
//        for (String x : s) {
//            int len = x.length();
//            if(len > max) {
//                max = len;
//                answer = x;
//            }
//        }

        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();

            if(len > max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }

        if(str.length() > max) answer = str;

        return answer;
    }
}
