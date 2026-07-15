import java.util.Scanner;

public class ProductSearchSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = {"Keyboard", "Mouse", "Monitor", "USB Cable", "Headset"};
        int[] prices = {890, 490, 5200, 250, 1290};
        int[] stocks = {12, 20, 5, 30, 8};

        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    printAllProducts(names, prices, stocks);
                    break;
                case 2:
                    searchExactName(scanner, names, prices, stocks);
                    break;
                case 3:
                    searchPartialName(scanner, names, prices, stocks);
                    break;
                case 4:
                    printLongestProductName(names, prices, stocks);
                    break;
                case 5:
                    showKeywordPosition(scanner, names);
                    break;
                case 0:
                    System.out.println("感謝使用，系統已結束。");
                    break;
                default:
                    System.out.println("錯誤：無效選項，請重新輸入！\n");
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=== 商品名稱搜尋系統 ===");
        System.out.println("1：顯示全部商品");
        System.out.println("2：完整名稱搜尋");
        System.out.println("3：部分名稱搜尋");
        System.out.println("4：顯示名稱最長的商品");
        System.out.println("5：顯示名稱與關鍵字首次出現位置");
        System.out.println("0：結束");
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

    public static void searchExactName(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("請輸入欲搜尋的完整商品名稱：");
        String input = sc.nextLine().trim();
        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(input)) {
                System.out.println("\n--- 搜尋結果 (精準匹配) ---");
                System.out.println("編號：" + (i + 1));
                System.out.println("名稱：" + names[i]);
                System.out.println("單價：" + prices[i] + " 元");
                System.out.println("庫存：" + stocks[i] + " 個\n");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("錯誤：找不到名稱完全相符的商品。\n");
        }
    }

    public static void searchPartialName(Scanner sc, String[] names, int[] prices, int[] stocks) {
        System.out.print("請輸入欲搜尋的部分關鍵字：");
        String input = sc.nextLine().trim().toLowerCase();
        boolean found = false;

        System.out.println("\n--- 搜尋結果 (部分匹配) ---");
        System.out.println("編號\t名稱\t\t單價\t庫存");
        for (int i = 0; i < names.length; i++) {
            if (names[i].toLowerCase().contains(input)) {
                System.out.println((i + 1) + "\t" + names[i] + (names[i].length() < 8 ? "\t\t" : "\t") + prices[i] + "\t" + stocks[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("(找不到任何包含此關鍵字的商品)");
        }
        System.out.println();
    }

    public static void printLongestProductName(String[] names, int[] prices, int[] stocks) {
        int longestIndex = 0;
        for (int i = 1; i < names.length; i++) {
            if (names[i].length() > names[longestIndex].length()) {
                longestIndex = i;
            }
        }

        System.out.println("\n--- 名稱最長的商品 ---");
        System.out.println("名稱：" + names[longestIndex]);
        System.out.println("長度：" + names[longestIndex].length() + " 個字元");
        System.out.println("單價：" + prices[longestIndex] + " 元");
        System.out.println("庫存：" + stocks[longestIndex] + " 個\n");
    }

    public static void showKeywordPosition(Scanner sc, String[] names) {
        System.out.print("請輸入搜尋定位的關鍵字：");
        String input = sc.nextLine();
        boolean found = false;

        System.out.println("\n--- 關鍵字首次出現位置 (區分大小寫) ---");
        for (int i = 0; i < names.length; i++) {
            int position = names[i].indexOf(input);
            if (position != -1) {
                System.out.println("商品 " + (i + 1) + " [" + names[i] + "]：首次出現在索引 " + position);
                found = true;
            }
        }

        if (!found) {
            System.out.println("在所有商品名稱中皆找不到關鍵字 \"" + input + "\"。");
        }
        System.out.println();
    }
}