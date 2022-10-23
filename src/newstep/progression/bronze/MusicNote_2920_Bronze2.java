package newstep.progression.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MusicNote_2920_Bronze2 {

    private static StringTokenizer st;
    private static int[] arr = new int[9];
    private static boolean asc, desc;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        st = new StringTokenizer(br.readLine());
//        for (int i = 1; i <= 8; i++) arr[i] = Integer.parseInt(st.nextToken());
//
//        for (int i = 1; i < 8; i++) {
//            if (arr[i + 1] > arr[i]) desc = true;
//            if (arr[i + 1] < arr[i]) asc = true;
//        }
//
//        if (!asc) System.out.print("ascending");
//        else if (!desc) System.out.print("descending");
//        else System.out.print("mixed");

        String input = br.readLine();
        String ascending = "1 2 3 4 5 6 7 8";
        String descending= "8 7 6 5 4 3 2 1";
        String output = input.equals(ascending) ?
                "ascending" : (input.equals(descending) ? "descending" : "mixed");
        System.out.println(output);
    }
}
