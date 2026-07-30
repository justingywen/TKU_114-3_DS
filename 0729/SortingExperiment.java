public class SortingExperiment {
    public static void main(String[] args) {
        int[] sorted = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] reversed = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
        int[] random = {45, 12, 89, 33, 71, 9, 64, 28, 95, 50};

        System.out.println("==== 已排序資料 ====");
        testSorts(sorted);

        System.out.println("\n==== 反向排序資料 ====");
        testSorts(reversed);

        System.out.println("\n==== 隨機排序資料 ====");
        testSorts(random);
        
        System.out.println("\n【觀察結論】");
        System.out.println("1. Selection Sort 比較次數不受資料初始狀態影響，交換次數少。");
        System.out.println("2. Insertion Sort 處理接近已排序資料時極快，比較與移動次數極低。");
        System.out.println("3. Insertion Sort 遇到反向資料為最差狀況，產生大量右移操作。");
    }

    public static void testSorts(int[] data) {
        selectionSort(data.clone());
        insertionSort(data.clone());
    }

    public static void selectionSort(int[] arr) {
        int comp = 0, swap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                comp++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int temp = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = temp;
                swap++;
            }
        }
        System.out.printf("Selection Sort -> 比較: %2d 次, 交換: %d 次%n", comp, swap);
    }

    public static void insertionSort(int[] arr) {
        int comp = 0, move = 0;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                comp++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    move++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        System.out.printf("Insertion Sort -> 比較: %2d 次, 移動: %d 次%n", comp, move);
    }
}