package newstep.progression.codewars;

import java.util.stream.IntStream;

public class Multiple3Or5_6kyu {
    public int solution(int number) {
        if (number < 0) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public int solutionCv(int number) {
        return IntStream.range(0, number)
            .filter(n -> (n % 3 == 0) || (n % 5 == 0))
            .sum();
    }

}
