import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RepairSchedulingSystem {
    public static void main(String[] args) {
        ArrayList<RepairTask> allTasks = new ArrayList<>();
        Deque<RepairTask> waitingQueue = new ArrayDeque<>();
        Deque<RepairTask> completedStack = new ArrayDeque<>();

        addTask(allTasks, waitingQueue, new RepairTask("T101", "Server A", 3));
        addTask(allTasks, waitingQueue, new RepairTask("T102", "Printer B", 5));
        addTask(allTasks, waitingQueue, new RepairTask("T103", "Switch C", 5));
        addTask(allTasks, waitingQueue, new RepairTask("T104", "Router D", 1));

        RepairTask[] taskArray = allTasks.toArray(new RepairTask[0]);
        RepairAlgorithms.mergeSortByPriorityStable(taskArray);

        System.out.println("\n依優先度降冪排序（保持穩定性）：");
        for (RepairTask t : taskArray) System.out.println(t);

        System.out.println("\n完成第一項工作：");
        processNext(waitingQueue, completedStack);

        System.out.println("\n復原最近完成工作：");
        undoLast(waitingQueue, completedStack);

        System.out.println("\n搜尋 T102：" + RepairAlgorithms.findById(allTasks, "T102"));

        System.out.println("\n統計摘要：");
        System.out.println("總工作數：" + allTasks.size());
        System.out.println("等待中數量：" + waitingQueue.size());
        System.out.println("已完成數量：" + completedStack.size());
    }

    public static void addTask(ArrayList<RepairTask> all, Deque<RepairTask> waiting, RepairTask task) {
        all.add(task);
        waiting.offer(task);
        System.out.println("成功新增維修工作：" + task);
    }

    public static void processNext(Deque<RepairTask> waiting, Deque<RepairTask> completed) {
        RepairTask t = waiting.poll();
        if (t == null) {
            System.out.println("目前無等待維修工作");
            return;
        }
        completed.push(t);
        System.out.println("完成維修：" + t);
    }

    public static void undoLast(Deque<RepairTask> waiting, Deque<RepairTask> completed) {
        RepairTask t = completed.poll();
        if (t == null) {
            System.out.println("沒有可復原的紀錄");
            return;
        }
        waiting.offerFirst(t);
        System.out.println("復原維修：" + t);
    }
}