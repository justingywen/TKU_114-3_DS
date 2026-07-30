import java.util.ArrayList;

public class RepairAlgorithms {

    public static void mergeSortByPriorityStable(RepairTask[] tasks) {
        if (tasks == null || tasks.length < 2) return;
        RepairTask[] temp = new RepairTask[tasks.length];
        mergeSortByPriorityStable(tasks, temp, 0, tasks.length - 1);
    }

    private static void mergeSortByPriorityStable(RepairTask[] tasks, RepairTask[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortByPriorityStable(tasks, temp, left, mid);
        mergeSortByPriorityStable(tasks, temp, mid + 1, right);
        mergePriority(tasks, temp, left, mid, right);
    }

    private static void mergePriority(RepairTask[] tasks, RepairTask[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (tasks[i].getPriority() >= tasks[j].getPriority()) {
                temp[k++] = tasks[i++];
            } else {
                temp[k++] = tasks[j++];
            }
        }
        while (i <= mid) temp[k++] = tasks[i++];
        while (j <= right) temp[k++] = tasks[j++];
        for (int index = left; index <= right; index++) tasks[index] = temp[index];
    }

    public static RepairTask findById(ArrayList<RepairTask> tasks, String id) {
        if (tasks == null || id == null) return null;
        for (RepairTask t : tasks) {
            if (t.getId().equalsIgnoreCase(id.trim())) return t;
        }
        return null;
    }

    public static ArrayList<RepairTask> findByDeviceName(ArrayList<RepairTask> tasks, String device) {
        ArrayList<RepairTask> results = new ArrayList<>();
        if (tasks == null || device == null) return results;
        for (RepairTask t : tasks) {
            if (t.getDeviceName().equalsIgnoreCase(device.trim())) {
                results.add(t);
            }
        }
        return results;
    }
}