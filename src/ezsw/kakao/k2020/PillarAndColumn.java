package ezsw.kakao.k2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PillarAndColumn {

    class Fail {
        private int stage;
        private double rate;

        Fail(int stage, double rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }
    Comparator<Fail> comp = new Comparator<Fail>() {
        List<Integer> list = new ArrayList<>();
        @Override
        public int compare(Fail o1, Fail o2) {
            List<Integer> a = new ArrayList<>();

            return 0;
        }
    };

    public static void main(String[] args) {

    }
}
