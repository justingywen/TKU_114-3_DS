import java.util.Random;

public class AlgorithmComparisonReport {
    private static long comparisonCount = 0;

    public static void main(String[] args) {
        int[] sizes = {16, 128, 1024};
        String[] types = {"Sorted", "Reversed", "Random"};

        System.out.printf("%-10s %-10s %-15s %-15s %-15s%n", "Size", "Type", "Selection Comparisons", "Insertion Comparisons", "Merge Comparisons");
        System.out.println("----------------------------------------------------------------------------------");

        for (int size : sizes) {
            for (String type : types) {
                int[] data = generateData(size, type);

                int[] selData = data.clone();
                comparisonCount = 0;
                selectionSort(selData);
                long selComp = comparisonCount;

                int[] insData = data.clone();
                comparisonCount = 0;
                insertionSort(insData);
                long insComp = comparisonCount;

                int[] mergeData = data.clone();
                comparisonCount = 0;
                mergeSort(mergeData);
                long mergeComp = comparisonCount;

                System.out.printf("%-10d %-10s %-22d %-22d %-15d%n", size, type, selComp, insComp, mergeComp);
            }
        }

        System.out.println("\n觀察結論：");
        System.out.println("1. Selection Sort 比較次數完全取決於 n，不受原始資料狀態影響。");
        System.out.println("2. Insertion Sort 在已排序狀態下僅需 O(n) 次比較，但在反向資料時次數陡增。");
        System.out.println("3. Merge Sort 無論資料狀態如何，比較次數穩定維持在約 O(n log n)。");
    }

    public static int[] generateData(int size, String type) {
        int[] arr = new int[size];
        if (type.equals("Sorted")) {
            for (int i = 0; i < size; i++) arr[i] = i;
        } else if (type.equals("Reversed")) {
            for (int i = 0; i < size; i++) arr[i] = size - i;
        } else {
            Random rand = new Random(42);
            for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);
        }
        return arr;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisonCount++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comparisonCount++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            comparisonCount++;
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (int index = left; index <= right; index++) arr[index] = temp[index];
    }
}