public class NumberHistoryList {
    private IntNode head;
    private int size;

    public NumberHistoryList() {
        head = null;
        size = 0;
    }

    public void addFirst(int value) {
        IntNode newNode = new IntNode(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int value) {
        IntNode newNode = new IntNode(value);
        if (head == null) {
            head = newNode;
        } else {
            IntNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean contains(int target) {
        IntNode current = head;
        while (current != null) {
            if (current.data == target) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean removeValue(int target) {
        if (head == null) {
            return false;
        }
        if (head.data == target) {
            head = head.next;
            size--;
            return true;
        }
        IntNode previous = head;
        IntNode current = head.next;
        while (current != null) {
            if (current.data == target) {
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void printStats() {
        if (head == null) {
            System.out.println("目前為空串列，無法計算總和、最大值與最小值。");
            return;
        }
        int sum = 0;
        int max = head.data;
        int min = head.data;
        IntNode current = head;

        while (current != null) {
            sum += current.data;
            if (current.data > max) max = current.data;
            if (current.data < min) min = current.data;
            current = current.next;
        }
        System.out.println("總數：" + size + " | 總和：" + sum + " | 最大值：" + max + " | 最小值：" + min);
    }

    public void printList() {
        IntNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        NumberHistoryList list = new NumberHistoryList();
        
        list.printStats(); // 測試空串列處理

        list.addLast(20);
        list.addLast(30);
        list.addFirst(10);
        list.addLast(40);
        list.printList();
        list.printStats();

        System.out.println("\n是否包含 30：" + list.contains(30));
        System.out.println("是否包含 99：" + list.contains(99));

        System.out.println("\n刪除 10 (頭部)：" + list.removeValue(10));
        System.out.println("刪除 40 (尾部)：" + list.removeValue(40));
        System.out.println("刪除 99 (不存在)：" + list.removeValue(99));
        
        list.printList();
        list.printStats();
    }
}