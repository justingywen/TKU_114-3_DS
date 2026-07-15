
import java.util.Scanner;

public class ProductArraySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        int purchaseCount = 0;
        int restockCount = 0;
        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printAllProducts(names, prices, stocks);
                    break;
                case 2:
                    queryProduct(scanner, names, prices, stocks);
                    break;
                case 3:
                    if (buyProduct(scanner, names, prices, stocks)) {
                        purchaseCount++;
                    }
                    break;
                case 4:
                    if (restockProduct(scanner, names, stocks)) {
                        restockCount++;
                    }
                    break;
                case 5:
                    printLowStockProducts(names, prices, stocks);
                    break;
                case 6:
                    int totalValue = calculateTotalValue(prices, stocks);
                    System.out.println("目前全部庫存總價值為：" + totalValue + " 元\n");
                    break;
                case 0:
                    System.out.println("系統結束，正在產生摘要...");
                    break;
                default:
                    System.out.println("錯誤：無效選項，請重新輸入！\n");
                    break;
            }
        }

        printFinalSummary(purchaseCount, restockCount);
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=== 商品管理系統 ===");
        System.out.println("1：顯示全部商品");
        System.out.println("2：依商品編號查詢");
        System.out.println("3：購買商品並扣除庫存");
        System.out.println("4：補充商品庫存");
        System.out.println("5：顯示低庫存商品");
        System.out.println("6：顯示全部庫存總價值");
        System.out.println("0：結束並顯示操作摘要");
        System.out.print("請輸入選項：");
    }

    public static void printAllProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n=== 商品清單 ===");
        System.out.println("編號\t名稱\t\t單價\t庫存");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + "\t" + names[i] + (names[i].length() < 8 ? "\t\t" : "\t") + prices[i] + "\t" + stocks[i]);
        }
        System.out.println();
    }

    public static void queryProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("請輸入商品編號 (1~" + names.length + ")：");
        int id = sc.nextInt();
        if (id < 1 || id > names.length) {
            System.out.println("錯誤：此商品編號不存在。\n");
            return;
        }
        int index = id - 1;
        System.out.println("\n--- 查詢結果 ---");
        System.out.println("名稱：" + names[index]);
        System.out.println("單價：" + prices[index] + " 元");
        System.out.println("庫存：" + stocks[index] + " 個\n");
    }

    public static boolean buyProduct(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("請輸入要購買的商品編號 (1~" + names.length + ")：");
        int id = sc.nextInt();
        if (id < 1 || id > names.length) {
            System.out.println("錯誤：此商品編號不存在。\n");
            return false;
        }
        int index = id - 1;
        if (stocks[index] == 0) {
            System.out.println("錯誤：該商品已無庫存，無法購買。\n");
            return false;
        }

        int quantity = 0;
        while (quantity <= 0 || quantity > stocks[index]) {
            System.out.print("請輸入購買數量 (目前庫存：" + stocks[index] + ")：");
            quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("錯誤：購買數量必須大於 0，請重新輸入！");
            } else if (quantity > stocks[index]) {
                System.out.println("錯誤：庫存不足，請重新輸入！");
            }
        }

        stocks[index] -= quantity;
        int cost = prices[index] * quantity;
        System.out.println("購買成功！已扣除 " + names[index] + " 庫存 " + quantity + " 個，總共 " + cost + " 元。\n");
        return true;
    }

    public static boolean restockProduct(Scanner sc, String[] names, int[] stocks) {
        System.out.print("請輸入要補貨的商品編號 (1~" + names.length + ")：");
        int id = sc.nextInt();
        if (id < 1 || id > names.length) {
            System.out.println("錯誤：此商品編號不存在。\n");
            return false;
        }
        int index = id - 1;

        int quantity = 0;
        while (quantity <= 0) {
            System.out.print("請輸入補貨數量：");
            quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("錯誤：補貨數量必須大於 0，請重新輸入！");
            }
        }

        stocks[index] += quantity;
        System.out.println("補貨成功！" + names[index] + " 新庫存為 " + stocks[index] + " 個。\n");
        return true;
    }

    public static void printLowStockProducts(String[] names, int[] prices, int[] stocks) {
        System.out.println("\n=== 低庫存商品清單 (庫存 < 10) ===");
        System.out.println("編號\t名稱\t\t單價\t庫存");
        boolean hasLowStock = false;
        for (int i = 0; i < names.length; i++) {
            if (stocks[i] < 10) {
                System.out.println((i + 1) + "\t" + names[i] + (names[i].length() < 8 ? "\t\t" : "\t") + prices[i] + "\t" + stocks[i]);
                hasLowStock = true;
            }
        }
        if (!hasLowStock) {
            System.out.println("(目前無任何商品低於庫存下限)");
        }
        System.out.println();
    }

    public static int calculateTotalValue(int[] prices, int[] stocks) {
        int totalValue = 0;
        for (int i = 0; i < prices.length; i++) {
            totalValue += prices[i] * stocks[i];
        }
        return totalValue;
    }

    public static void printFinalSummary(int purchaseCount, int restockCount) {
        System.out.println("\n=== 操作摘要 ===");
        System.out.println("本次系統執行期間：");
        System.out.println("成功購買交易次數：" + purchaseCount + " 次");
        System.out.println("成功補貨執行次數：" + restockCount + " 次");
        System.out.println("感謝您的使用！");
    }
}