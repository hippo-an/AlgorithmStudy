package newstep.concept;

import java.util.Arrays;

public class UnionFindOptimize {

    private static final int[] parents = new int[5];

    private static int cnt = 0;

    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            parents[i] = i;
        }

        unionNoOptimize(1, 2);
        unionNoOptimize(2, 3);
        unionNoOptimize(3, 4);

        cnt = 1;
        System.out.printf("부모 배열: %s\n", Arrays.toString(parents));
        System.out.println(isConnected(1, 2));

        System.out.println("===============");

        cnt = 1;
        System.out.printf("부모 배열: %s\n", Arrays.toString(parents));
        System.out.println(isConnected(1, 2));
    }

    private static int findParent(final int node) {
        if (cnt != 0) {
            System.out.println("cnt: " + cnt++);
        }
        if (parents[node] == node) {
            return node;
        }

        return parents[node] = findParent(parents[node]);
    }


    private static void unionNoOptimize(final int node1, final int node2) {
        final int parent1 = findParent(node1);
        final int parent2 = findParent(node2);

        parents[parent1] = parent2;
    }

    private static void unionOptimize(final int node1, final int node2) {
        final int parent1 = findParent(node1);
        final int parent2 = findParent(node2);

        if (parent1 == parent2) {
            return;
        }

        if (parent1 < parent2) {
            parents[parent2] = parent1;
        } else {
            parents[parent1] = parent2;
        }
    }

    // 두 노드의 부모 노드를 확인해 같은지 확인 - true -> 연결성이 있다, false -> 연결성이 없다
    private static boolean isConnected(final int node1, final int node2) {
        final int parent1 = findParent(node1);
        final int parent2 = findParent(node2);

        return parent1 == parent2;
    }
}
