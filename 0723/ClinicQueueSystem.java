import java.util.ArrayDeque;
import java.util.Deque;

public class ClinicQueueSystem {
    private Deque<Patient> waitingQueue = new ArrayDeque<>();
    private int totalServed = 0;

    public void register(Patient p) {
        for (Patient waiting : waitingQueue) {
            if (waiting.getNumber().equalsIgnoreCase(p.getNumber())) {
                System.out.println("掛號失敗：號碼 " + p.getNumber() + " 已經在等待名單中。");
                return;
            }
        }
        waitingQueue.offer(p);
        System.out.println("掛號成功：" + p);
    }

    public void callNext() {
        Patient next = waitingQueue.poll();
        if (next != null) {
            System.out.println("請 " + next + " 進入診間。");
            totalServed++;
        } else {
            System.out.println("目前無人候診。");
        }
    }

    public void printStatus() {
        System.out.println("\n--- 診所候診資訊 ---");
        if (!waitingQueue.isEmpty()) {
            System.out.println("下一位候診：" + waitingQueue.peek());
        }
        
        int internalCount = 0;
        int surgicalCount = 0;
        
        System.out.print("等待清單：");
        for (Patient p : waitingQueue) {
            System.out.print(p.getNumber() + " ");
            if (p.getDepartment().equals("內科")) internalCount++;
            if (p.getDepartment().equals("外科")) surgicalCount++;
        }
        
        System.out.println("\n等待人數統計 -> 內科：" + internalCount + " 人 | 外科：" + surgicalCount + " 人");
        System.out.println("今日已服務總人數：" + totalServed);
        System.out.println("-------------------\n");
    }

    public static void main(String[] args) {
        ClinicQueueSystem clinic = new ClinicQueueSystem();

        clinic.register(new Patient("N01", "王大明", "內科"));
        clinic.register(new Patient("S01", "李小華", "外科"));
        clinic.register(new Patient("N02", "陳阿姨", "內科"));
        clinic.register(new Patient("N01", "張三", "內科"));

        clinic.printStatus();

        clinic.callNext();
        clinic.callNext();

        clinic.printStatus();
    }
}