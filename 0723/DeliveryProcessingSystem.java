import java.util.ArrayDeque;
import java.util.Deque;

public class DeliveryProcessingSystem {
    private Deque<DeliveryTask> waitingTasks = new ArrayDeque<>();
    private Deque<DeliveryTask> completedHistory = new ArrayDeque<>();

    public void addTask(DeliveryTask task) {
        waitingTasks.offer(task);
        System.out.println("新增配送工作：" + task);
    }

    public void completeNext() {
        DeliveryTask task = waitingTasks.poll();
        if (task != null) {
            completedHistory.push(task);
            System.out.println("已完成配送：" + task);
        } else {
            System.out.println("目前沒有等待中的配送工作。");
        }
    }

    public void peekNext() {
        if (!waitingTasks.isEmpty()) {
            System.out.println("下一筆配送工作：" + waitingTasks.peek());
        } else {
            System.out.println("目前沒有等待中的配送工作。");
        }
    }

    public void undoLastCompleted() {
        if (completedHistory.isEmpty()) {
            System.out.println("復原失敗：沒有已完成的紀錄。");
            return;
        }
        DeliveryTask task = completedHistory.pop();
        waitingTasks.offer(task);
        System.out.println("已復原工作 (重新加入等候列)：" + task);
    }

    public void printSummary() {
        System.out.println("\n--- 配送系統統計 ---");
        System.out.println("等待中工作數量：" + waitingTasks.size());
        System.out.println("已完成工作數量：" + completedHistory.size());
        
        System.out.print("所有完成紀錄 (由近到遠)：");
        for (DeliveryTask t : completedHistory) {
            System.out.print(t + " | ");
        }
        System.out.println("\n--------------------");
    }

    public static void main(String[] args) {
        DeliveryProcessingSystem system = new DeliveryProcessingSystem();

        system.addTask(new DeliveryTask("D001", "台北車站"));
        system.addTask(new DeliveryTask("D002", "松山機場"));
        system.addTask(new DeliveryTask("D003", "信義計畫區"));

        system.peekNext();
        system.completeNext();
        system.completeNext();
        
        system.printSummary();

        System.out.println("\n--- 觸發復原 ---");
        system.undoLastCompleted();
        
        system.printSummary();
        
        System.out.println("\n--- 繼續處理 ---");
        system.peekNext();
        system.completeNext();
        system.completeNext();
    }
}