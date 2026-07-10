package week1_practice;

import java.util.Scanner;

public class PatternGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // 九九乘法表不需要額外輸入，直接呼叫
                    printMultiplicationTable();
                    break;

                case 2:
                    int triHeight = readPositiveInt(scanner, "請輸入正三角形高度：");
                    printTriangle(triHeight);
                    break;

                case 3:
                    int revTriHeight = readPositiveInt(scanner, "請輸入倒三角形高度：");
                    printReverseTriangle(revTriHeight);
                    break;

                case 4:
                    int rows = readPositiveInt(scanner, "請輸入方格列數 (rows)：");
                    int cols = readPositiveInt(scanner, "請輸入方格欄數 (cols)：");
                    printNumberGrid(rows, cols);
                    break;

                case 0:
                    System.out.println("感謝您的使用，再見！");
                    break;

                default:
                    System.out.println("錯誤：無效選項，請重新輸入！\n");
                    break;
            }
        }

        scanner.close();
    }

    // 顯示圖形產生器主選單
    public static void printMenu() {
        System.out.println("=== Pattern & Table Generator ===");
        System.out.println("1. 九九乘法表");
        System.out.println("2. 正三角形星號");
        System.out.println("3. 倒三角形星號");
        System.out.println("4. 數字方格");
        System.out.println("0. 離開");
        System.out.print("請輸入選項：");
    }

    // 讀取並驗證大於 0 的整數（高度、列數、欄數防呆）
    public static int readPositiveInt(Scanner sc, String message) {
        int value = 0;
        while (value <= 0) {
            System.out.print(message);
            value = sc.nextInt();
            if (value <= 0) {
                System.out.println("錯誤：數值必須大於 0，請重新輸入！");
            }
        }
        return value;
    }

    // 選項 1：輸出完整九九乘法表
    public static void printMultiplicationTable() {
        System.out.println("\n--- 九九乘法表 ---");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                // 使用 \t (Tab) 讓排版自動對齊
                System.out.print(j + "x" + i + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 選項 2：輸出正三角形星號
    public static void printTriangle(int height) {
        System.out.println("\n--- 正三角形 ---");
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 選項 3：輸出倒三角形星號
    public static void printReverseTriangle(int height) {
        System.out.println("\n--- 倒三角形 ---");
        for (int i = height; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 選項 4：輸出動態列數與欄數的數字方格
    public static void printNumberGrid(int rows, int cols) {
        System.out.println("\n--- 數字方格 ---");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}