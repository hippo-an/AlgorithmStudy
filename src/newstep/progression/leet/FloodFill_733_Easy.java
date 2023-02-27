package newstep.progression.leet;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill_733_Easy {

    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Integer> queue = new LinkedList<>();
        int oldColor = image[sr][sc];

        if (oldColor == color) {
            return image;
        }

        queue.add(sr);
        queue.add(sc);

        while (!queue.isEmpty()) {
            int r = queue.poll();
            int c = queue.poll();

            image[r][c] = color;

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image[0].length && image[nr][nc] == oldColor) {
                    image[nr][nc] = color;
                    queue.add(nr);
                    queue.add(nc);
                }
            }
        }

        return image;
    }
}
