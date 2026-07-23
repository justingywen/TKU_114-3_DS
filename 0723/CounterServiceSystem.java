import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CounterServiceSystem {
    public static void main(String[] args) {
        Deque<String> waitingQueue = new ArrayDeque<>();
        List<String> historyRecords = new ArrayList<>();

        takeTicket(waitingQueue, "A001 艾咪");
        takeTicket(waitingQueue, "A002 班恩");
        takeTicket(waitingQueue, "A003 卡拉");

        printStatus(waitingQueue);

        callNext(waitingQueue, historyRecords);
        callNext(waitingQueue, historyRecords);

        printStatus(waitingQueue);

        callNext(waitingQueue, historyRecords);
        callNext(waitingQueue, historyRecords);

        System.out.println("\n--- 今日處理紀錄 ---");
        for (String record : historyRecords) {
            System.out.println("已服務：" + record);
        }
    }

    public static void takeTicket(Deque<String> queue, String info) {
        queue.offer(info);
        System.out.println("取號成功：" + info);
    }

    public static void callNext(Deque<String> queue, List<String> history) {
        String nextPerson = queue.poll();
        if (nextPerson == null) {
            System.out.println("請注意：目前無人等待服務。");
        } else {
            System.out.println("請 " + nextPerson + " 到櫃檯。");
            history.add(nextPerson);
        }
    }

    public static void printStatus(Deque<String> queue) {
        System.out.println("--- 目前狀態 ---");
        System.out.println("等待人數：" + queue.size());
        if (!queue.isEmpty()) {
            System.out.println("下一位是：" + queue.peek());
        }
        System.out.println("--------------");
    }
}