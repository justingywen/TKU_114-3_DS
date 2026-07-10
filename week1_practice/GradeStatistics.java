package week1_practice;

import java.util.Scanner;

public class GradeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 初始化累加器與計數器
        int count = 0;
        int total = 0;
        int max = 0;      // 用最低可能分數當最大值起點
        int min = 100;    // 用最高可能分數當最小值起點
        int passCount = 0;
        int failCount = 0;

        while (true) {
            System.out.print("請輸入成績（輸入 -1 結束）：");
            int score = scanner.nextInt();

            // 檢查是否為結束訊號
            if (score == -1) {
                break;
            }

            // 呼叫輸入驗證 method，不合法則跳過本次迴圈
            if (!isValidScore(score)) {
                System.out.println("錯誤：成績範圍必須在 0 到 100 之間，請重新輸入！");
                continue;
            }

            // 更新最高分與最低分
            if (score > max) {
                max = score;
            }
            if (score < min) {
                min = score;
            }

            // 累加總分與次數
            total = total + score;
            count++;

            // 判斷及格與否
            if (isPassing(score)) {
                passCount++;
            } else {
                failCount++;
            }
        }

        // 處理特殊情況：第一筆就輸入 -1 的防護機制
        if (count == 0) {
            System.out.println("No scores entered.");
        } else {
            // 計算精準的平均值（轉 double 避免整數除法）
            double average = (double) total / count;
            String grade = getGrade(average);

            // 呼叫輸出統計結果的 method
            printSummary(count, total, average, max, min, passCount, failCount, grade);
        }

        scanner.close();
    }

    // 驗證成績是否在合法的 0 ~ 100 區間內
    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100;
    }

    // 判斷該分數是否達到 60 分及格標準
    public static boolean isPassing(int score) {
        return score >= 60;
    }

    // 根據平均分數轉換成對應的英文字母等第
    public static String getGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // 印出最終統計報表
    public static void printSummary(int count, int total, double average, int max, int min, int passCount, int failCount, String grade) {
        System.out.println("\n=== Grade Summary ===");
        System.out.println("Count: " + count);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Pass count: " + passCount);
        System.out.println("Fail count: " + failCount);
        System.out.println("Average grade: " + grade);
    }
}