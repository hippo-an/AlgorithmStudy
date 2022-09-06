package kakaooo;

import java.util.*;

public class ParkingFee {

    private static final int[] cars = new int[10000];
    private static final int[] times = new int[10000];
    private static int[] FEE;
    private static final String IN = "IN", OUT = "OUT";


    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        FEE = fees;

        for (String s : records) {
            st = new StringTokenizer(s);
            int time = calcTime(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            String inOut = st.nextToken();

            if (IN.equalsIgnoreCase(inOut)) {
                cars[number] = time;
            } else {
                times[number] += time - cars[number];
                cars[number] = 0;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0 ; i < 10000; i++) {
            if (cars[i] != 0) {
                times[i] += 1440 - cars[i];
            }

            if (times[i] != 0) {
                ans.add(calcFee(times[i]));
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) answer[i] = ans.get(i);
        return answer;
    }

    private int calcFee(int time) {
        if (time <= FEE[0]) return FEE[1];
        int base = time - FEE[0];
        return (FEE[1] +  (base / FEE[2]) * FEE[3]) + (base % FEE[2] == 0 ? 0 : FEE[3]);
    }

    private int calcTime(String timeString) {
        String[] s = timeString.split(":");
        return (Integer.parseInt(s[0]) * 60) + Integer.parseInt(s[1]) + 1;
    }
}
