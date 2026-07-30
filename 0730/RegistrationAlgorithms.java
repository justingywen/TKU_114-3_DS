import java.util.ArrayList;

public class RegistrationAlgorithms {

    public static void mergeSortById(Registration[] regs) {
        if (regs == null || regs.length < 2) return;
        Registration[] temp = new Registration[regs.length];
        mergeSortById(regs, temp, 0, regs.length - 1);
    }

    private static void mergeSortById(Registration[] regs, Registration[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortById(regs, temp, left, mid);
        mergeSortById(regs, temp, mid + 1, right);
        merge(regs, temp, left, mid, right);
    }

    private static void merge(Registration[] regs, Registration[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (regs[i].getId().compareTo(regs[j].getId()) <= 0) {
                temp[k++] = regs[i++];
            } else {
                temp[k++] = regs[j++];
            }
        }
        while (i <= mid) temp[k++] = regs[i++];
        while (j <= right) temp[k++] = regs[j++];
        for (int index = left; index <= right; index++) regs[index] = temp[index];
    }

    public static int binarySearchById(Registration[] regs, String id) {
        if (regs == null || id == null) return -1;
        int low = 0, high = regs.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = id.compareTo(regs[mid].getId());
            if (cmp == 0) return mid;
            if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static ArrayList<Registration> findByName(ArrayList<Registration> list, String name) {
        ArrayList<Registration> res = new ArrayList<>();
        if (list == null || name == null) return res;
        for (Registration r : list) {
            if (r.getName().equalsIgnoreCase(name.trim())) res.add(r);
        }
        return res;
    }

    public static boolean containsId(ArrayList<Registration> list, String id) {
        if (list == null || id == null) return false;
        for (Registration r : list) {
            if (r.getId().equalsIgnoreCase(id.trim())) return true;
        }
        return false;
    }
}