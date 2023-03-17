package newstep.progression.hackerrank.implementation;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ClimbingTheLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        Integer[] rank = ranked.stream().distinct().toArray(Integer[]::new);

        List<Integer> ans = new ArrayList<>();

        for (Integer score : player) {
            ans.add(binarySearch(rank, score) + 1);
        }

        return ans;
    }

    private static Integer binarySearch(Integer[] rank, Integer score) {
        int l = 0;
        int r = rank.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (rank[mid] < score) {
                r = mid - 1;
            } else if (rank[mid] > score) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return l;
    }

}
