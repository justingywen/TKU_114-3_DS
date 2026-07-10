package week1_practice;

import java.util.Scanner;

public class DrinkOrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        int totalItems = 0;
        int totalAmount = 0;

        // 各商品销售杯數計數器
        int blackTeaCount = 0;
        int greenTeaCount = 0;
        int milkTeaCount = 0;
        int coffeeCount = 0;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();

            // 檢查是否為合法的飲料選項 (1~4)
            if (choice >= 1 && choice <= 4) {
                String itemName = getItemName(choice);
                int price = getPrice(choice);
                int quantity = readValidQuantity(scanner);
                int subtotal = calculateSubtotal(price, quantity);

                System.out.println(itemName + " x " + quantity);
                System.out.println("Subtotal: " + subtotal + "\n");

                // 分流累加各商品的銷售數量
                switch (choice) {
                    case 1:
                        blackTeaCount = blackTeaCount + quantity;
                        break;
                    case 2:
                        greenTeaCount = greenTeaCount + quantity;
                        break;
                    case 3:
                        milkTeaCount = milkTeaCount + quantity;
                        break;
                    case 4:
                        coffeeCount = coffeeCount + quantity;
                        break;
                }

                // 累加總杯數與折扣前總金額
                totalItems = totalItems + quantity;
                totalAmount = totalAmount + subtotal;

            } else if (choice != 0) {
                System.out.println("無效選項，請重新輸入！\n");
            }
        }

        // 計算折扣後的最終金額並列印收據
        int finalAmount = calculateDiscountedTotal(totalAmount);
        printReceipt(blackTeaCount, greenTeaCount, milkTeaCount, coffeeCount, totalItems, totalAmount, finalAmount);

        scanner.close();
    }

    // 顯示商品選單介面
    public static void printMenu() {
        System.out.println("=== Drink Menu ===");
        System.out.println("1. Black tea  $30");
        System.out.println("2. Green tea  $35");
        System.out.println("3. Milk tea   $45");
        System.out.println("4. Coffee     $50");
        System.out.println("0. Checkout");
        System.out.print("請輸入選項：");
    }

    // 根據選項回傳價格
    public static int getPrice(int option) {
        switch (option) {
            case 1: return 30;
            case 2: return 35;
            case 3: return 45;
            case 4: return 50;
            default: return 0;
        }
    }

    // 根據選項回傳商品名稱
    public static String getItemName(int option) {
        switch (option) {
            case 1: return "Black tea";
            case 2: return "Green tea";
            case 3: return "Milk tea";
            case 4: return "Coffee";
            default: return "";
        }
    }

    // 讀取合法數量（必須大於 0）
    public static int readValidQuantity(Scanner sc) {
        int quantity = 0;
        while (quantity <= 0) {
            System.out.print("請輸入數量：");
            quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("錯誤：數量必須大於 0，請重新輸入！");
            }
        }
        return quantity;
    }

    // 計算單次商品小計
    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    // 根據規則計算折扣後金額（滿 300 打 9 折，不滿維持原價）
    public static int calculateDiscountedTotal(int totalAmount) {
        if (totalAmount >= 300) {
            // 乘以 0.9 後強制轉為 int（無條件捨去小數點）
            return (int) (totalAmount * 0.9);
        } else {
            return totalAmount;
        }
    }

    // 印出包含明細與折扣資訊的完整收據
    public static void printReceipt(int blackTeaCount, int greenTeaCount, int milkTeaCount, int coffeeCount, int totalItems, int totalAmount, int finalAmount) {
        System.out.println("\n=== Receipt ===");
        System.out.println("Black tea: " + blackTeaCount);
        System.out.println("Green tea: " + greenTeaCount);
        System.out.println("Milk tea: " + milkTeaCount);
        System.out.println("Coffee: " + coffeeCount);
        System.out.println("Total items: " + totalItems);
        System.out.println("Original amount: " + totalAmount);
        
        // 判斷原價與最終金額是否不同，來決定顯示有無折扣
        if (totalAmount >= 300) {
            System.out.println("Discount: 10% OFF");
        } else {
            System.out.println("Discount: No");
        }
        
        System.out.println("Final amount: " + finalAmount);
    }
}