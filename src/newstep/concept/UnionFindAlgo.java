package newstep.concept;

public class UnionFindAlgo {


    private static int[] parents = new int[8];

    public static void main(String[] args) {
        // 자기 자신을 부모 노드의 값으로 초기화
        for (int i = 1; i <= 7; i++) {
            parents[i] = i;
        }

        // 연결성 추가 union(1, 2) 는 union (2, 1) 과 같은 의미
        union(1, 2);
        union(2, 3);
        union(3, 5);
        union(7, 3);
        union(4, 6);

        System.out.println("1과 7은 연결되어 있나요? " + isConnected(1, 7));  // true
        System.out.println("5와 1은 연결되어 있나요? " + isConnected(5, 1));  // true
        System.out.println("6과 4는 연결되어 있나요? " + isConnected(6, 4));  // true
        System.out.println("2와 6은 연결되어 있나요? " + isConnected(2, 6));  // false

        // 만약 6과 1의 연결을 추가하는 경우
        union(6, 1);

        System.out.println("2와 6은 연결되어 있나요? " + isConnected(2, 6));  // true
    }

    private static int findParent(final int node) {
        if (parents[node] == node) {
            return node;
        }

        return findParent(parents[node]);
    }

    private static void union(final int node1, final int node2) {
        final int parent1 = findParent(node1);
        final int parent2 = findParent(node2);

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
