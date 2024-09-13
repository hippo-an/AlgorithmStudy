package hobby.datastructure.maps;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WhosInTheOffice_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Boolean> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if ("enter".equals(action)) {
                map.putIfAbsent(name, true);
            } else {
                map.remove(name);
            }
        }
        String collect = map.keySet()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining("\n"));

        bw.write(collect);
        bw.flush();
        bw.close();
        br.close();

    }
}
