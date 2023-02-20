package newstep.progression.codewars;

import java.util.stream.Collectors;

public class SquareDigits_7kyu {
    public int squareDigits(int n) {
        String intVal = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (char c : intVal.toCharArray()) {
            int numericValue = Character.getNumericValue(c);
            sb.append(numericValue * numericValue);
        }
        return Integer.parseInt(sb.toString());
    }

    public int squareDigitsBp(int n) {
        return Integer.parseInt(String.valueOf(n)
            .chars()
            .map(i -> Integer.parseInt(String.valueOf((char) i)))
            .map(i -> i * i)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining("")));
    }

}
