import java.util.Arrays;

public class RangeSearchSystem {
    public static void main(String[] args) {
        int[] sortedValues = {5, 10, 10, 10, 20, 20, 30, 40};
        
        testRangeSearch(sortedValues, 10);
        testRangeSearch(sortedValues, 20);
        testRangeSearch(sortedValues, 99); // 不存在的目標測試
    }

    public static void testRangeSearch(int[] values, int target) {
        int[] range = findOccurrenceRange(values, target);
        int count = (range[0] == -1) ? 0 : (range[1] - range[0] + 1);

        System.out.printf("搜尋目標 %d => 區間範圍：%s | 出現次數：%d%n",
                target, Arrays.toString(range), count);
    }

    public static int[] findOccurrenceRange(int[] values, int target) {
        int first = findBound(values, target, true);
        int last = findBound(values, target, false);
        return new int[]{first, last};
    }

    private static int findBound(int[] values, int target, boolean searchFirst) {
        int low = 0;
        int high = values.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (values[mid] == target) {
                result = mid; // 記錄索引後，勿立刻返回，進一步逼近邊界！
                if (searchFirst) {
                    high = mid - 1; // 嘗試向左找更早出現的位置
                } else {
                    low = mid + 1;  // 嘗試向右找更晚出現的位置
                }
            } else if (target < values[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}