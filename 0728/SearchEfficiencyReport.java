public class SearchEfficiencyReport {
    public static void main(String[] args) {
        int[] sizes = {16, 128, 1024};

        for (int size : sizes) {
            int[] data = generateSortedArray(size);
            System.out.println("==========================================");
            System.out.println("測試資料規模 (n) = " + size);
            System.out.println("==========================================");

            // 測試第一筆 (最理想 Sequential 條件)
            runCompareTest(data, data[0], "第一筆資料 (" + data[0] + ")");
            // 測試最後一筆 (極端測試)
            runCompareTest(data, data[size - 1], "最後一筆資料 (" + data[size - 1] + ")");
            // 測試不存在的數字 (最差條件比拚)
            runCompareTest(data, -1, "不存在的資料 (-1)");
            System.out.println();
        }

        printConclusions();
    }

    public static void runCompareTest(int[] data, int target, String caseName) {
        int seqCount = getSequentialComparisonCount(data, target);
        int binCount = getBinaryComparisonCount(data, target);
        System.out.printf("[案例] %-15s | Sequential 比較: %4d 次 | Binary 比較: %2d 次%n",
                caseName, seqCount, binCount);
    }

    public static int getSequentialComparisonCount(int[] data, int target) {
        int count = 0;
        for (int val : data) {
            count++;
            if (val == target) break;
        }
        return count;
    }

    public static int getBinaryComparisonCount(int[] data, int target) {
        int count = 0;
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            count++;
            int mid = low + (high - low) / 2;
            if (data[mid] == target) break;
            if (target < data[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return count;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (i + 1) * 2;
        }
        return arr;
    }

    public static void printConclusions() {
        System.out.println("======= 效率觀察結論 =======");
        System.out.println("1. O(n) 的特徵：循序搜尋的最差情況比較次數等於陣列長度 (N)；唯獨在目標剛好於陣列首位時效率高。");
        System.out.println("2. O(log n) 的特徵：二分搜尋不受限於目標於陣列前或後，1024 筆資料最多僅需 11 次比較，效率提升巨大。");
        System.out.println("3. 選擇指南：當查詢次數頻繁且資料已排好序時，必須選用 Binary Search 以省去過長的搜尋次數。");
    }
}