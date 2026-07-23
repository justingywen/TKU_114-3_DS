public class LinkedListReverse {
    public static void main(String[] args) {
        System.out.println("--- 測試多節點 ---");
        IntNode head1 = new IntNode(10);
        head1.next = new IntNode(20);
        head1.next.next = new IntNode(30);
        printList(head1);
        head1 = reverse(head1);
        printList(head1);

        System.out.println("\n--- 測試單一節點 ---");
        IntNode head2 = new IntNode(10);
        printList(head2);
        head2 = reverse(head2);
        printList(head2);

        System.out.println("\n--- 測試空串列 ---");
        IntNode head3 = null;
        printList(head3);
        head3 = reverse(head3);
        printList(head3);
    }

    public static IntNode reverse(IntNode head) {
        IntNode previous = null;
        IntNode current = head;

        while (current != null) {
            IntNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return previous;
    }

    public static void printList(IntNode head) {
        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}