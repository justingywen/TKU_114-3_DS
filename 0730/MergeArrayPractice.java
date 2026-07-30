import java.util.Arrays;

public class MergeArrayPractice {
    public static void main(String[] args) {
        int[] left = {-5, 3, 12, 20};
        int[] right = {-2, 5, 8, 20, 30, 50};

        int[] result = merge(left, right);
        System.out.println("合併結果：" + Arrays.toString(result));

        int[] emptyLeft = {};
        int[] resultWithEmpty = merge(emptyLeft, right);
        System.out.println("包含空陣列合併：" + Arrays.toString(resultWithEmpty));
    }

    public static int[] merge(int[] left, int[] right) {
        if (left == null) left = new int[0];
        if (right == null) right = new int[0];

        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }
}