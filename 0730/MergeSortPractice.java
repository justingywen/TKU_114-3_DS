import java.util.Arrays;

public class MergeSortPractice {
    public static void main(String[] args) {
        int[] values = {41, 12, 35, 8, 27, 19, 50, 3};
        System.out.println("原始陣列：" + Arrays.toString(values));
        mergeSort(values);
        System.out.println("排序完成：" + Arrays.toString(values));

        testBoundary(new int[]{});
        testBoundary(new int[]{5});
        testBoundary(new int[]{1, 2, 3, 4});
        testBoundary(new int[]{4, 3, 2, 1});
    }

    public static void testBoundary(int[] values) {
        System.out.println("\n邊界測試前：" + Arrays.toString(values));
        mergeSort(values);
        System.out.println("邊界測試後：" + Arrays.toString(values));
    }

    public static void mergeSort(int[] values) {
        if (values == null || values.length < 2) {
            return;
        }
        int[] temp = new int[values.length];
        mergeSort(values, temp, 0, values.length - 1, 0);
    }

    private static void mergeSort(int[] values, int[] temp, int left, int right, int depth) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        int[] leftRange = Arrays.copyOfRange(values, left, mid + 1);
        int[] rightRange = Arrays.copyOfRange(values, mid + 1, right + 1);
        System.out.printf("%s拆分 [%d..%d] -> 左 [%d..%d]: %s, 右 [%d..%d]: %s%n",
                "  ".repeat(depth), left, right, left, mid, Arrays.toString(leftRange), mid + 1, right, Arrays.toString(rightRange));

        mergeSort(values, temp, left, mid, depth + 1);
        mergeSort(values, temp, mid + 1, right, depth + 1);
        merge(values, temp, left, mid, right);

        int[] mergedRange = Arrays.copyOfRange(values, left, right + 1);
        System.out.printf("%s合併 [%d..%d] 結果：%s%n",
                "  ".repeat(depth), left, right, Arrays.toString(mergedRange));
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

        while (i <= mid) {
            temp[k++] = values[i++];
        }

        while (j <= right) {
            temp[k++] = values[j++];
        }

        for (int index = left; index <= right; index++) {
            values[index] = temp[index];
        }
    }
}