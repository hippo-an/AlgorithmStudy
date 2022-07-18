package fastcampus;

public class SingleLinkedList<T> {

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(4);
        linkedList.addNode(3);

        linkedList.print();


    }
    public Node<T> head = null;

    public void addNode(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> node = this.head;
            while(node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
        }

    }

    public void print() {
        if (head == null) {
            System.out.println("Linked list is empty!");
        } else {
            Node<T> node = head;
            while (node.next != null) {
                System.out.print(node.data + " -> ");
                node = node.next;
            }
            System.out.print(node.data + "\n");
        }
    }






    private static class Node<T> {
        private final T data;
        private Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
