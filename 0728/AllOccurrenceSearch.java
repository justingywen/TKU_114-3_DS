public class AllOccurrenceSearch {
    public static void main(String[] args) {
        int[] values = {15, 8, 23, 8, 42, 8, 16, 99};
        int target = 8;

        searchAll(values, target);
        searchAll(values, 100); // 測試不存在的值
    }

    public static void searchAll(int[] values, int target) {
        int count = 0;
        int comparisons = 0;

        System.out.printf("--- 開始搜尋數值 [%d] ---%n", target);
        for (int i = 0; i < values.length; i++) {
            comparisons++;
            if (values[i] == target) {
                System.out.println("找到相符資料於索引：" + i);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("結果：找不到指定的資料。");
        } else {
            System.out.println("出現總次數：" + count);
        }
        System.out.println("實際檢查比較次數：" + comparisons);
        System.out.println();
    }
}