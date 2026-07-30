import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class EventRegistrationSystem {
    private static final int MAX_CAPACITY = 2;

    public static void main(String[] args) {
        ArrayList<Registration> mainList = new ArrayList<>();
        Deque<Registration> waitQueue = new ArrayDeque<>();
        Deque<Registration> cancelStack = new ArrayDeque<>();

        register(mainList, waitQueue, new Registration("R101", "Alice"));
        register(mainList, waitQueue, new Registration("R102", "Bob"));
        register(mainList, waitQueue, new Registration("R103", "Cara"));
        register(mainList, waitQueue, new Registration("R101", "Duplicate"));

        Registration[] arr = mainList.toArray(new Registration[0]);
        RegistrationAlgorithms.mergeSortById(arr);

        System.out.println("\nBinary Search 查詢 R102：" +
                (RegistrationAlgorithms.binarySearchById(arr, "R102") != -1 ? "存在" : "不存在"));

        System.out.println("\n取消報名 R101：");
        cancelRegistration(mainList, waitQueue, cancelStack, "R101");

        System.out.println("\n復原取消操作：");
        undoCancel(mainList, waitQueue, cancelStack);
    }

    public static boolean register(ArrayList<Registration> mainList, Deque<Registration> waitQueue, Registration reg) {
        if (RegistrationAlgorithms.containsId(mainList, reg.getId())) {
            System.out.println("報名失敗：編號 " + reg.getId() + " 重複！");
            return false;
        }
        if (mainList.size() < MAX_CAPACITY) {
            mainList.add(reg);
            System.out.println("正式報名成功：" + reg);
        } else {
            waitQueue.offer(reg);
            System.out.println("進入候補佇列：" + reg);
        }
        return true;
    }

    public static void cancelRegistration(ArrayList<Registration> mainList, Deque<Registration> waitQueue, Deque<Registration> cancelStack, String id) {
        Registration target = null;
        for (Registration r : mainList) {
            if (r.getId().equalsIgnoreCase(id)) {
                target = r;
                break;
            }
        }
        if (target != null) {
            mainList.remove(target);
            cancelStack.push(target);
            System.out.println("正式名額已取消：" + target);

            Registration promoted = waitQueue.poll();
            if (promoted != null) {
                mainList.add(promoted);
                System.out.println("候補補上正式名額：" + promoted);
            }
        } else {
            System.out.println("錯誤：找不到欲取消的資料 " + id);
        }
    }

    public static void undoCancel(ArrayList<Registration> mainList, Deque<Registration> waitQueue, Deque<Registration> cancelStack) {
        Registration restored = cancelStack.poll();
        if (restored == null) {
            System.out.println("沒有可復原的取消紀錄");
            return;
        }
        mainList.add(restored);
        System.out.println("成功復原取消報名：" + restored);
    }
}