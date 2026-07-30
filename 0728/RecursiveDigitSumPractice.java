public class RecursiveDigitSumPractice {
    public static void main(String[] args) {
        int[] testCases = {5729, 0, 8, 12345, 999};
        for (int test : testCases) {
            System.out.printf("digitSum(%d) = %d%n", test, digitSum(test));
        }
    }

    public static int digitSum(int number) {
        // Base case: 若處理至最後一位數或原本就是 0，直接回傳
        if (number == 0) {
            return 0;
        }
        // Recursive case: 目前個位數 + 遞迴處理剩餘數字 (除以 10)
        return (number % 10) + digitSum(number / 10);
    }
}