import java.util.Scanner;

public class ProductDataManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] records = {
            "Keyboard,890,12",
            "Mouse,490,20",
            "Monitor,5200,5",
            "USB Cable,250,30",
            "Headset,1290,8"
        };

        int maxCapacity = 100;
        String[] names = new String[maxCapacity];
        int[] prices = new int[maxCapacity];
        int[] stocks = new int[maxCapacity];
        int productCount = 0;

        for (String record : records) {
            String[] parts = record.split(",");
            names[productCount] = parts[0];
            prices[productCount] = Integer.parseInt(parts[1]);
            stocks[productCount] = Integer.parseInt(parts[2]);
            productCount++;
        }

        int choice = -1;
        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printTable(names, prices, stocks, productCount);
                    break;
                case 2:
                    searchByName(scanner, names, prices, stocks, productCount);
                    break;
                case 3:
                    printLowStock(names, prices, stocks, productCount);
                    break;
                case 4:
                    int totalValue = calculateTotalValue(prices, stocks, productCount);
                    System.out.println("全部庫存總價值為：" + totalValue + " 元\n");
                    break;
                case 5:
                    if (productCount >= maxCapacity) {
                        System.out.println("錯誤：資料庫已滿，無法新增商品！\n");
                    } else {
                        boolean success = addNewRecord(scanner, names, prices, stocks, productCount);
                        if (success) {
                            productCount++;
                        }
                    }
                    break;
                case 0:
                    System.out.println("系統已結束，感謝您的使用！");
                    break;
                default:
                    System.out.println("錯誤：無效選項，請重新輸入！\n");
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=== 商品文字資料管理器 ===");
        System.out.println("1：顯示商品表格");
        System.out.println("2：搜尋商品名稱 (支援完整與部分搜尋)");
        System.out.println("3：顯示低庫存商品 (庫存 < 10)");
        System.out.println("4：顯示庫存總價值");
        System.out.println("5：輸入新商品文字資料 (CSV 格式)");
        System.out.println("0：結束系統");
        System.out.print("請輸入選項：");
    }

    public static void printTable(String[] names, int[] prices, int[] stocks, int count) {
        System.out.println("\n=== 解析後的商品報表 ===");
        System.out.println("編號\t名稱\t\t單價\t庫存");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + "\t" + names[i] + (names[i].length() < 8 ? "\t\t" : "\t") + prices[i] + "\t" + stocks[i]);
        }
        System.out.println();
    }

    public static void searchByName(Scanner sc, String[] names, int[] prices, int[] stocks, int count) {
        System.out.print("請輸入要搜尋的商品名稱：");
        String keyword = sc.nextLine().trim().toLowerCase();
        boolean found = false;

        System.out.println("\n--- 搜尋結果 ---");
        System.out.println("編號\t名稱\t\t單價\t庫存\t匹配類型");
        for (int i = 0; i < count; i++) {
            String currentNameLower = names[i].toLowerCase();
            if (currentNameLower.equals(keyword)) {
                System.out.println((i + 1) + "\t" + names[i] + (names[i].length() < 8 ? "\t\t" : "\t") + prices[i] + "\t" + stocks[i] + "\t完整匹配");
                found = true;
            } else if (currentNameLower.contains(keyword)) {
                System.out.println((i + 1) + "\t" + names[i] + (names[i].length() < 8 ? "\t\t" : "\t") + prices[i] + "\t" + stocks[i] + "\t部分匹配");
                found = true;
            }
        }

        if (!found) {
            System.out.println("(找不到符合此關鍵字的商品)");
        }
        System.out.println();
    }

    public static void printLowStock(String[] names, int[] prices, int[] stocks, int count) {
        System.out.println("\n=== 低庫存商品 (庫存 < 10) ===");
        System.out.println("編號\t名稱\t\t單價\t庫存");
        boolean hasLowStock = false;
        for (int i = 0; i < count; i++) {
            if (stocks[i] < 10) {
                System.out.println((i + 1) + "\t" + names[i] + (names[i].length() < 8 ? "\t\t" : "\t") + prices[i] + "\t" + stocks[i]);
                hasLowStock = true;
            }
        }
        if (!hasLowStock) {
            System.out.println("(目前無任何商品庫存低於 10)");
        }
        System.out.println();
    }

    public static int calculateTotalValue(int[] prices, int[] stocks, int count) {
        int totalValue = 0;
        for (int i = 0; i < count; i++) {
            totalValue += prices[i] * stocks[i];
        }
        return totalValue;
    }

    public static boolean addNewRecord(Scanner sc, String[] names, int[] prices, int[] stocks, int count) {
        System.out.print("請輸入商品文字資料 (格式：名稱,價格,庫存)：");
        String input = sc.nextLine().trim();

        String[] parts = input.split(",");
        if (parts.length != 3) {
            System.out.println("錯誤：欄位數量不正確！必須包含「名稱,價格,庫存」三個欄位（以半形逗號分隔）。\n");
            return false;
        }

        String tempName = parts[0].trim();
        if (tempName.isEmpty()) {
            System.out.println("錯誤：商品名稱不能為空白！\n");
            return false;
        }

        int tempPrice = 0;
        try {
            tempPrice = Integer.parseInt(parts[1].trim());
            if (tempPrice < 0) {
                System.out.println("錯誤：單價不能為負數！\n");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("錯誤：價格格式不正確！無法將 \"" + parts[1].trim() + "\" 轉換成整數。\n");
            return false;
        }

        int tempStock = 0;
        try {
            tempStock = Integer.parseInt(parts[2].trim());
            if (tempStock < 0) {
                System.out.println("錯誤：庫存量不能為負數！\n");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("錯誤：庫存格式不正確！無法將 \"" + parts[2].trim() + "\" 轉換成整數。\n");
            return false;
        }

        names[count] = tempName;
        prices[count] = tempPrice;
        stocks[count] = tempStock;

        System.out.println("成功解析並新增商品：" + tempName + " (價格：" + tempPrice + "，庫存：" + tempStock + ")\n");
        return true;
    }
}