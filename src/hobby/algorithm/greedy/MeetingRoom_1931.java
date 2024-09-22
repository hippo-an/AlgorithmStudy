package hobby.algorithm.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MeetingRoom_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Meeting> m = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            m.add(new Meeting(start, end));
        }

        Collections.sort(m);

        int ans = 0;
        int lastEndTime = 0;
        for (Meeting meeting : m) {
            if (meeting.start < lastEndTime) {
                continue;
            }

            ans++;
            lastEndTime = meeting.end;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();

    }

    /*
    1) 클래스를 정의하고 Comparable 인터페이스의 compareTo 메서드를 재정의하여 정렬 기준을 맞춰준다.
     */
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
