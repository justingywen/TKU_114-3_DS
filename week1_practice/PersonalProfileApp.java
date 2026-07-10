package week1_practice;

import java.util.Scanner;

public class PersonalProfileApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = scanner.nextLine();

        // 使用指定 method 讀取並驗證年齡、身高、體重
        int age = readPositiveInt(scanner, "請輸入年齡：");
        double height = readPositiveDouble(scanner, "請輸入身高（公尺）：");
        double weight = readPositiveDouble(scanner, "請輸入體重（公斤）：");

        // 呼叫邏輯運算與判斷 method
        double bmi = calculateBmi(height, weight);
        String level = getBmiLevel(bmi);
        boolean adult = isAdult(age);

        // 呼叫輸出報表 method
        printReport(name, age, adult, height, weight, bmi, level);

        scanner.close();
    }

    // 驗證並讀取大於 0 的整數（年齡）
    public static int readPositiveInt(Scanner sc, String message) {
        int value = 0;
        while (value <= 0) {
            System.out.print(message);
            value = sc.nextInt();
            if (value <= 0) {
                System.out.println("錯誤：輸入必須大於 0，請重新輸入！");
            }
        }
        return value;
    }

    // 驗證並讀取大於 0 的浮點數（身高、體重）
    public static double readPositiveDouble(Scanner sc, String message) {
        double value = 0;
        while (value <= 0) {
            System.out.print(message);
            value = sc.nextDouble();
            if (value <= 0) {
                System.out.println("錯誤：輸入必須大於 0，請重新輸入！");
            }
        }
        return value;
    }

    // 計算 BMI 公式：體重 / (身高 * 身高)
    public static double calculateBmi(double height, double weight) {
        return weight / (height * height);
    }

    // 依據 BMI 數值進行區間分級
    public static String getBmiLevel(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24) {
            return "Normal";
        } else if (bmi >= 24 && bmi < 27) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // 判斷年齡是否滿 18 歲成年
    public static boolean isAdult(int age) {
        return age >= 18;
    }

    // 輸出最終健康報表結果
    public static void printReport(String name, int age, boolean adult, double height, double weight, double bmi, String level) {
        System.out.println("\n=== Personal Health Report ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Adult: " + adult);
        System.out.println("Height: " + height);
        System.out.println("Weight: " + weight);
        System.out.println("BMI: " + bmi);
        System.out.println("Level: " + level);
    }
}