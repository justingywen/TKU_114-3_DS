import java.util.Scanner;

public class SeatNumberSearchPractice {
    public static void main(String[] args) {
        int[] seats = {101, 105, 108, 112, 115, 120, 125, 130, 135, 140, 145, 150};
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要查詢的座位編號: ");
        int target = scanner.nextInt();
        int index = binarySearchWithTrace(seats, target);

        if (index != -1) {
            System.out.println("查詢成功！座位索引於: " + index);
        } else {
            System.out.println("查無此座位編號。");
        }
        scanner.close();
    }

    public static int binarySearchWithTrace(int[] values, int target) {
        int low = 0;
        int high = values.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.printf("[追蹤] low=%d, mid=%d, high=%d, 中間值=%d%n", low, mid, high, values[mid]);

            if (values[mid] == target) {
                return mid;
            } else if (target < values[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}