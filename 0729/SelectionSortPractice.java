import java.util.Arrays;

public class SelectionSortPractice {
    public static void main(String[] args) {
        int[] values = {42, 18, 35, 7, 29, 14};
        int comparisons = 0;
        int swaps = 0;

        System.out.println("初始：" + Arrays.toString(values));

        for (int start = 0; start < values.length - 1; start++) {
            int minIndex = start;
            for (int index = start + 1; index < values.length; index++) {
                comparisons++;
                if (values[index] < values[minIndex]) {
                    minIndex = index;
                }
            }
            if (minIndex != start) {
                int temp = values[start];
                values[start] = values[minIndex];
                values[minIndex] = temp;
                swaps++;
            }
            System.out.printf("第 %d 輪 (start=%d, 選中的索引=%d)：%s%n", 
                              start + 1, start, minIndex, Arrays.toString(values));
        }
        System.out.printf("總比較次數：%d，總交換次數：%d%n", comparisons, swaps);
    }
}