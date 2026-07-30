import java.util.Arrays;

public class InventorySearchPractice {
    public static void main(String[] args) {
        int[] inventoryIds = {501, 102, 305, 888, 204, 110, 403, 999, 607, 702, 101, 205};

        System.out.println("排序前庫存編號：" + Arrays.toString(inventoryIds));
        mergeSort(inventoryIds);
        System.out.println("排序後庫存編號：" + Arrays.toString(inventoryIds));

        int[] targets = {101, 999, 500};
        for (int target : targets) {
            int index = binarySearch(inventoryIds, target);
            if (index != -1) {
                System.out.println("查詢 " + target + " -> 成功找到，索引位置為：" + index);
            } else {
                System.out.println("查詢 " + target + " -> 找不到此編號");
            }
        }
    }

    public static void mergeSort(int[] values) {
        if (values == null || values.length < 2) return;
        int[] temp = new int[values.length];
        mergeSort(values, temp, 0, values.length - 1);
    }

    private static void mergeSort(int[] values, int[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(values, temp, left, mid);
        mergeSort(values, temp, mid + 1, right);
        merge(values, temp, left, mid, right);
    }

    private static void merge(int[] values, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (values[i] <= values[j]) {
                temp[k++] = values[i++];
            } else {
                temp[k++] = values[j++];
            }
        }

        while (i <= mid) temp[k++] = values[i++];
        while (j <= right) temp[k++] = values[j++];

        for (int index = left; index <= right; index++) {
            values[index] = temp[index];
        }
    }

    public static int binarySearch(int[] values, int target) {
        int low = 0;
        int high = values.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (values[mid] == target) {
                return mid;
            } else if (values[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}