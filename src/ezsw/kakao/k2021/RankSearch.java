package ezsw.kakao.k2021;

import java.util.*;
import java.util.stream.Collectors;

public class RankSearch {
    public static void main(String[] args) {

    }

    Map<String, Integer> WordMap = new HashMap<>();
    List<List<Integer>> scoreList = new ArrayList<>();

    public int[] solution(String[] info, String[] query) {
        // 인덱스 변환시 쉽게 하기 위한 맵
        WordMap.put("-", 0);
        WordMap.put("cpp", 1);
        WordMap.put("java", 2);
        WordMap.put("python", 3);
        WordMap.put("backend", 1);
        WordMap.put("frontend", 2);
        WordMap.put("junior", 1);
        WordMap.put("senior", 2);
        WordMap.put("chicken", 1);
        WordMap.put("pizza", 2);

        for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
            scoreList.add(new ArrayList<>());
        }

        for(String str : info) {
            String[] word = str.split(" ");
            int[] arr = {
                    WordMap.get(word[0]) * 3*3*3,
                    WordMap.get(word[1]) *3*3,
                    WordMap.get(word[2]) *3,
                    WordMap.get(word[3]),
            };

            int score = Integer.parseInt(word[4]);

            for (int i = 0; i < (1 << 4); i++) {
                int idx = 0;
                for (int j = 0; j < 4; j++) {
                    if((i & (1<<j)) != 0) {
                        idx += arr[j];
                    }
                }
                scoreList.get(idx).add(score);
            }
        }

        for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
            Collections.sort(scoreList.get(i));
        }

        int[] answer = new int[query.length];

        for(int i = 0; i < query.length; i++) {
            String[] word = query[i].replaceAll("and ", "").split(" ");
            int idx = WordMap.get(word[0]) * 3 * 3 * 3 +
                    WordMap.get(word[2]) * 3 * 3+
                    WordMap.get(word[4]) * 3 +
                    WordMap.get(word[6]);

            int score = Integer.parseInt(word[7]);

            int ret = Collections.binarySearch(scoreList.get(idx), score);
            if(ret < 0) {
                ret = -(ret + 1);
            } else {
                for (int j = ret - 1; j >= 0; j--) {
                    if (scoreList.get(idx).get(j) == score)
                        ret = j;
                    else
                        break;
                }

                answer[i] = scoreList.get(idx).size() - ret;
            }

        }
        return answer;
    }
}
