import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class OrderManagementPractice {
    public static void main(String[] args) {
        ArrayList<Order> allOrders = new ArrayList<>();
        Deque<Order> waitingQueue = new ArrayDeque<>();
        Deque<Order> completedStack = new ArrayDeque<>();

        addOrder(allOrders, waitingQueue, new Order("O205", "Amy", 1800));
        addOrder(allOrders, waitingQueue, new Order("O101", "Ben", 650));
        addOrder(allOrders, waitingQueue, new Order("O330", "Amy", 2400));
        addOrder(allOrders, waitingQueue, new Order("O205", "Duplicate", 9999));

        Order[] orderArray = allOrders.toArray(new Order[0]);
        OrderAlgorithms.mergeSortByAmountDesc(orderArray);

        System.out.println("依金額降冪排序：");
        for (Order o : orderArray) {
            System.out.println(o);
        }

        System.out.println("\n顯示下一筆待處理訂單：");
        Order next = waitingQueue.peek();
        System.out.println(next != null ? next : "目前無待處理訂單");

        System.out.println("\n處理訂單流程：");
        processNext(waitingQueue, completedStack);
        processNext(waitingQueue, completedStack);

        System.out.println("\n復原訂單流程：");
        undoLast(waitingQueue, completedStack);

        System.out.println("\n測試空 Queue / Stack 邊界操作：");
        processNext(new ArrayDeque<>(), new ArrayDeque<>());
        undoLast(new ArrayDeque<>(), new ArrayDeque<>());
    }

    public static boolean addOrder(ArrayList<Order> allOrders, Deque<Order> waiting, Order order) {
        if (OrderAlgorithms.containsId(allOrders, order.getId())) {
            System.out.println("新增失敗：訂單編號 " + order.getId() + " 已存在！");
            return false;
        }
        allOrders.add(order);
        waiting.offer(order);
        System.out.println("成功新增訂單：" + order);
        return true;
    }

    public static void processNext(Deque<Order> waiting, Deque<Order> completed) {
        Order order = waiting.poll();
        if (order == null) {
            System.out.println("錯誤：待處理佇列為空！");
            return;
        }
        completed.push(order);
        System.out.println("完成處理：" + order);
    }

    public static void undoLast(Deque<Order> waiting, Deque<Order> completed) {
        Order order = completed.poll();
        if (order == null) {
            System.out.println("錯誤：沒有可復原的紀錄！");
            return;
        }
        waiting.offerFirst(order);
        System.out.println("成功復原：" + order);
    }
}