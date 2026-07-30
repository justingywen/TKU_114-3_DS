import java.util.Arrays;

public class SortingDebugReport {
    public static void main(String[] args) {
        int[] data = {5, 3, 4, 1, 2};

        System.out.println("【錯誤 1：內層範圍錯誤】");
        System.out.println("原始資料: " + Arrays.toString(data));
        buggySelectionSort(data.clone());
        fixedSelectionSort(data.clone());

        System.out.println("\n【錯誤 2：key 未保存】");
        System.out.println("原始資料: " + Arrays.toString(data));
        buggyInsertionSort(data.clone());
        fixedInsertionSort(data.clone());

        System.out.println("\n【錯誤 3：降冪比較方向錯誤】");
        System.out.println("原始資料: " + Arrays.toString(data));
        buggyDescendingSort(data.clone());
        fixedDescendingSort(data.clone());
    }

    // 錯誤 1: 內層迴圈 j 從 0 開始，導致已排序區被重複處理破壞
    public static void buggySelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = 0; j < arr.length; j++) { // BUG
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = temp;
        }
        System.out.println("錯誤輸出: " + Arrays.toString(arr));
    }
    public static void fixedSelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) { // 修正：從 i + 1 開始
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = temp;
        }
        System.out.println("修正輸出: " + Arrays.toString(arr));
    }

    // 錯誤 2: 沒有保存 key，元素右移時直接將原本的值覆蓋掉
    public static void buggyInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[i]) { // BUG: 比較物件被動態覆蓋
                arr[j + 1] = arr[j];
                j--;
            }
        }
        System.out.println("錯誤輸出: " + Arrays.toString(arr));
    }
    public static void fixedInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // 修正：先暫存 key
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key; // 修正：放入正確位置
        }
        System.out.println("修正輸出: " + Arrays.toString(arr));
    }

    // 錯誤 3: 欲執行降冪排序，但比較運算子錯誤地寫成 <
    public static void buggyDescendingSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[maxIdx]) maxIdx = j; // BUG
            }
            int temp = arr[i]; arr[i] = arr[maxIdx]; arr[maxIdx] = temp;
        }
        System.out.println("錯誤輸出: " + Arrays.toString(arr));
    }
    public static void fixedDescendingSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j; // 修正：改成 >
            }
            int temp = arr[i]; arr[i] = arr[maxIdx]; arr[maxIdx] = temp;
        }
        System.out.println("修正輸出: " + Arrays.toString(arr));
    }
}