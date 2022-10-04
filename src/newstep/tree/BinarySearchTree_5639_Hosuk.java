package newstep.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree_5639_Hosuk {
    private static List<Integer> a;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        a = new ArrayList<>();
        while ((input = br.readLine()) != null) {
            if (input.isEmpty()) break;
            a.add(Integer.parseInt(input));
        }

        traverse(0, a.size() - 1);
        System.out.print(sb);
    }

    private static void traverse(int l, int r) {
        if (l > r) return;
        int mid = r;
        for (int i = l + 1; i <= r; i++) {
            if (a.get(i) > a.get(l)) {
                mid = i - 1;
                break;
            }
        }
        System.out.println("this is l, r, mid = " + l + "/" + r + "/" + mid);

        traverse(l + 1, mid);
        traverse(mid + 1, r);
        sb.append(a.get(l)).append("\n");
    }
}
