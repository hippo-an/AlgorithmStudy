package acmicpc.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class AC_5430_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryCount = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (tryCount-- > 0) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");
            Deque<Integer> deque = new ArrayDeque<>();

            while (st.hasMoreTokens()) {
                int element = Integer.parseInt(st.nextToken());
                deque.offerLast(element);
            }

            boolean direction = true;
            boolean parseFlag = true;

            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    direction = !direction;
                } else {
                    if (deque.size() == 0) {
                        parseFlag = false;
                        break;
                    }
                    if (direction) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (parseFlag) {
                sb.append("[");
                int loopSize = deque.size();

                for (int i = 0; i < loopSize; i++) {
                    if (direction) {
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }
                    if (loopSize - 1 != i) {
                        sb.append(",");
                    }
                }
                sb.append("]");
            } else {
                sb.append("error");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
