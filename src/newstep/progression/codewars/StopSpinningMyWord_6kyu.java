package newstep.progression.codewars;

import java.util.StringTokenizer;

public class StopSpinningMyWord_6kyu {
    public String spinWords(String sentence) {
        StringTokenizer st = new StringTokenizer(sentence, " ");
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            String word = st.nextToken();
            if (word.length() >= 5) {
                sb.append(new StringBuilder(word).reverse());
            } else {
                sb.append(word);
            }

            if (st.hasMoreTokens()) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public String spinWordsBp(String sentence) {
        String[] words = sentence.split(" ");
        for (int i=0; i<words.length; i++) {
            if (words[i].length() >= 5) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        return String.join(" ",words);
    }

}
