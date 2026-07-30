public class RecursiveDigitCounter {
    public static void main(String[] args) {
        int[] numbers = {12232, 0, 9999, 100001, 5, 4567};
        int[] targets = {2, 0, 9, 0, 5, 8};

        for (int i = 0; i < numbers.length; i++) {
            int count = countDigit(numbers[i], targets[i]);
            System.out.printf("數字 %d 中 %d 出現次數：%d%n", numbers[i], targets[i], count);
        }
    }

    public static int countDigit(int number, int target) {
        if (target < 0 || target > 9) {
            throw new IllegalArgumentException("目標數字須介於 0~9 之間");
        }
        // 處理輸入本為 0 且 target 也為 0 的特殊邊界情境
        if (number == 0) {
            return target == 0 ? 1 : 0;
        }
        return countDigitHelper(Math.abs(number), target);
    }

    private static int countDigitHelper(int number, int target) {
        if (number == 0) {
            return 0;
        }
        int currentDigit = number % 10;
        int match = (currentDigit == target) ? 1 : 0;
        return match + countDigitHelper(number / 10, target);
    }
}