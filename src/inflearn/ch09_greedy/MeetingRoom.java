package inflearn.ch09_greedy;

/**
 * 회의실 배정
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들
 * 려고 한다. 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하
 * 면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 단, 회의는 한번 시작하면 중간에 중
 * 단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * ▣ 입력설명
 * 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정
 * 보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
 * 회의 시간은 0시부터 시작된다.
 * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
 * ▣ 출력설명
 * 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
 * ▣ 입력예제 1
 * 5
 * 1 4
 * 2 3
 * 3 5
 * 4 6
 * 5 7
 * ▣ 출력예제 1
 * 3
 */

import java.util.*;

public class MeetingRoom {

    Comparator<Meeting> comp = new Comparator<Meeting>() {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            if(o1.e == o2.e) return o1.s - o2.s;
            return o1.e - o2.e;
        }
    };

    public static void main(String[] args) {
        MeetingRoom main = new MeetingRoom();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Meeting> list = new ArrayList<>();

        for(int i = 0; i < n; i ++) {
            list.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(main.solution(list, n));


    }

    private int solution(List<Meeting> list, int n) {
        int answer = 0;
        list.sort(comp);

        int et = 0;
        for (Meeting x : list) {
            if (x.s >= et) {
                et = x.e;
                answer++;
            }
        }

        return answer;
    }

    static class Meeting implements Comparable<Meeting> {
        int s, e;
        Meeting(int s, int e) {
            this.s = s; this.e = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.e == o.e) return this.s - o.s;
            return this.e - o.e;
        }
    }


}
