package newstep.search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SharpEyes_1637 {

    private static int N;
    private static List<Card> cards = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cards.add(new Card(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        long L = 1, R = Integer.MAX_VALUE, ans = 0;

        while (L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                R = mid - 1;
            } else L = mid + 1;
        }

        int cnt = 0;
        if (ans == 0) System.out.println("NOTHING");
        else {
            for (int i = 0; i < N; i++) {
                Card card = cards.get(i);
                if (card.min <= ans && card.max >= ans && (ans - card.min) % card.gap == 0) cnt++;
            }
            System.out.println(ans + " " + cnt);
        }
    }

    private static boolean determination(long mid) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += getSum(mid, cards.get(i));
        }
        return sum % 2 == 1;
    }

    private static long getSum(long mid, Card card) {
        if (card.min > mid) return 0;
        else if (card.max < mid) return  (card.max - card.min) / card.gap + 1;
        return (mid - card.min) / card.gap + 1;
    }

    private static class Card {
        int min;
        int max;
        int gap;


        public Card(int min, int max, int gap) {
            this.min = min;
            this.max = max;
            this.gap = gap;
        }
    }
}
