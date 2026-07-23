public class TaskLinkedList {
    private TaskNode head;
    private int totalCount;

    public TaskLinkedList() {
        head = null;
        totalCount = 0;
    }

    public void addUrgentTask(String code, String description) {
        TaskNode newNode = new TaskNode(code, description);
        newNode.next = head;
        head = newNode;
        totalCount++;
        System.out.println("已插入緊急工作：" + description);
    }

    public void addNormalTask(String code, String description) {
        TaskNode newNode = new TaskNode(code, description);
        if (head == null) {
            head = newNode;
        } else {
            TaskNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        totalCount++;
        System.out.println("已加入一般工作：" + description);
    }

    public void completeTask(String code) {
        TaskNode current = head;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                if (!current.isCompleted) {
                    current.isCompleted = true;
                    System.out.println("已完成工作：" + current.description);
                } else {
                    System.out.println("該工作已經處於完成狀態。");
                }
                return;
            }
            current = current.next;
        }
        System.out.println("找不到工作代碼：" + code);
    }

    public void removeTask(String code) {
        if (head == null) return;

        if (head.code.equalsIgnoreCase(code)) {
            System.out.println("已刪除工作：" + head.description);
            head = head.next;
            totalCount--;
            return;
        }

        TaskNode previous = head;
        TaskNode current = head.next;
        while (current != null) {
            if (current.code.equalsIgnoreCase(code)) {
                System.out.println("已刪除工作：" + current.description);
                previous.next = current.next;
                totalCount--;
                return;
            }
            previous = current;
            current = current.next;
        }
        System.out.println("無法刪除，找不到工作代碼：" + code);
    }

    public void printUncompletedTasks() {
        int uncompletedCount = 0;
        TaskNode current = head;
        System.out.println("--- 未完成工作清單 ---");
        while (current != null) {
            if (!current.isCompleted) {
                System.out.println("[" + current.code + "] " + current.description);
                uncompletedCount++;
            }
            current = current.next;
        }
        System.out.println("--------------------");
        System.out.println("工作總數：" + totalCount + " | 未完成數量：" + uncompletedCount);
    }
}