import java.util.Scanner;

public class ProductManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] products = new Product[10];
        int productCount = 0;

        products[0] = new Product("Keyboard", 890, 12);
        products[1] = new Product("Mouse", 490, 20);
        products[2] = new Product("Monitor", 5200, 5);
        products[3] = new Product("USB Cable", 250, 30);
        products[4] = new Product("Headset", 1290, 8);
        productCount = 5;

        int purchaseTransactions = 0;
        int restockTransactions = 0;
        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllProducts(products, productCount);
                    break;
                case 2:
                    searchProductByName(scanner, products, productCount);
                    break;
                case 3:
                    if (productCount >= products.length) {
                        System.out.println("錯誤：商品資料庫已滿 (上限 10 筆)，無法新增商品！\n");
                    } else {
                        boolean added = addNewProduct(scanner, products, productCount);
                        if (added) {
                            productCount++;
                        }
                    }
                    break;
                case 4:
                    if (sellProduct(scanner, products, productCount)) {
                        purchaseTransactions++;
                    }
                    break;
                case 5:
                    if (restockProduct(scanner, products, productCount)) {
                        restockTransactions++;
                    }
                    break;
                case 6:
                    modifyProductPrice(scanner, products, productCount);
                    break;
                case 7:
                    displayLowStockProducts(products, productCount);
                    break;
                case 8:
                    displayTotalInventoryValue(products, productCount);
                    break;
                case 0:
                    System.out.println("系統準備結束，正在彙整摘要...");
                    break;
                default:
                    System.out.println("錯誤：無效選項，請重新輸入！\n");
                    break;
            }
        }

        printOperationSummary(purchaseTransactions, restockTransactions);
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=== 物件導向商品管理系統 ===");
        System.out.println("1：顯示全部商品");
        System.out.println("2：依完整名稱搜尋");
        System.out.println("3：新增商品");
        System.out.println("4：出售商品");
        System.out.println("5：補充商品庫存");
        System.out.println("6：修改商品價格");
        System.out.println("7：顯示低庫存商品");
        System.out.println("8：顯示全部庫存總價值");
        System.out.println("0：結束並顯示操作摘要");
        System.out.print("請輸入選項：");
    }

    public static void displayAllProducts(Product[] products, int count) {
        System.out.println("\n=== 商品列表 ===");
        System.out.println("編號\t名稱\t\t單價\t庫存");
        for (int i = 0; i < count; i++) {
            Product p = products[i];
            System.out.println((i + 1) + "\t" + p.getName() + (p.getName().length() < 8 ? "\t\t" : "\t") + p.getPrice() + "\t" + p.getStock());
        }
        System.out.println();
    }

    public static void searchProductByName(Scanner sc, Product[] products, int count) {
        System.out.print("請輸入欲精準搜尋的商品名稱：");
        String targetName = sc.nextLine().trim();
        int index = findProductIndexByName(products, count, targetName);

        if (index != -1) {
            Product p = products[index];
            System.out.println("\n--- 搜尋結果 ---");
            System.out.println("商品名稱：" + p.getName());
            System.out.println("商品單價：" + p.getPrice() + " 元");
            System.out.println("當前庫存：" + p.getStock() + " 個");
            System.out.println("低庫存狀態：" + (p.isLowStock() ? "是 (庫存不足 10)" : "否") + "\n");
        } else {
            System.out.println("錯誤：找不到名稱為 \"" + targetName + "\" 的商品。\n");
        }
    }

    public static boolean addNewProduct(Scanner sc, Product[] products, int count) {
        System.out.print("請輸入新增商品名稱：");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("錯誤：商品名稱不能為空白！\n");
            return false;
        }

        if (findProductIndexByName(products, count, name) != -1) {
            System.out.println("錯誤：商品名稱 \"" + name + "\" 已存在，不可重複新增！\n");
            return false;
        }

        System.out.print("請輸入商品價格：");
        int price = sc.nextInt();
        System.out.print("請輸入商品初始庫存：");
        int stock = sc.nextInt();
        sc.nextLine();

        Product temp = new Product(name, price, stock);
        products[count] = temp;
        System.out.println("成功新增商品：" + temp.getName() + "！\n");
        return true;
    }

    public static boolean sellProduct(Scanner sc, Product[] products, int count) {
        System.out.print("請輸入欲出售的商品名稱：");
        String name = sc.nextLine().trim();
        int index = findProductIndexByName(products, count, name);

        if (index == -1) {
            System.out.println("錯誤：找不到此商品，交易中止。\n");
            return false;
        }

        Product p = products[index];
        System.out.print("請輸入出售數量 (目前庫存：" + p.getStock() + ")：");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (p.sell(quantity)) {
            System.out.println("交易成功！已售出 " + p.getName() + " 共 " + quantity + " 個。\n");
            return true;
        } else {
            System.out.println("錯誤：出售失敗。數量必須大於 0 且不可大於現有庫存！\n");
            return false;
        }
    }

    public static boolean restockProduct(Scanner sc, Product[] products, int count) {
        System.out.print("請輸入欲補貨的商品名稱：");
        String name = sc.nextLine().trim();
        int index = findProductIndexByName(products, count, name);

        if (index == -1) {
            System.out.println("錯誤：找不到此商品，補貨失敗。\n");
            return false;
        }

        Product p = products[index];
        System.out.print("請輸入補貨數量：");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (p.restock(quantity)) {
            System.out.println("補貨成功！" + p.getName() + " 最新庫存為 " + p.getStock() + " 個。\n");
            return true;
        } else {
            System.out.println("錯誤：補貨失敗。補貨數量必須大於 0！\n");
            return false;
        }
    }

    public static void modifyProductPrice(Scanner sc, Product[] products, int count) {
        System.out.print("請輸入欲修改價格的商品名稱：");
        String name = sc.nextLine().trim();
        int index = findProductIndexByName(products, count, name);

        if (index == -1) {
            System.out.println("錯誤：找不到此商品，修改失敗。\n");
            return;
        }

        Product p = products[index];
        System.out.print("請輸入新價格 (舊價格：" + p.getPrice() + ")：");
        int newPrice = sc.nextInt();
        sc.nextLine();

        if (p.setPrice(newPrice)) {
            System.out.println("價格修改成功！" + p.getName() + " 新單價為 " + p.getPrice() + " 元。\n");
        } else {
            System.out.println("錯誤：修改失敗。商品單價必須大於 0！\n");
        }
    }

    public static void displayLowStockProducts(Product[] products, int count) {
        System.out.println("\n=== 低庫存商品清單 (庫存 < 10) ===");
        System.out.println("名稱\t\t單價\t庫存");
        boolean found = false;
        for (int i = 0; i < count; i++) {
            Product p = products[i];
            if (p.isLowStock()) {
                System.out.println(p.getName() + (p.getName().length() < 8 ? "\t\t" : "\t") + p.getPrice() + "\t" + p.getStock());
                found = true;
            }
        }
        if (!found) {
            System.out.println("(目前無任何低庫存商品)");
        }
        System.out.println();
    }

    public static void displayTotalInventoryValue(Product[] products, int count) {
        int totalValue = 0;
        for (int i = 0; i < count; i++) {
            totalValue += products[i].getInventoryValue();
        }
        System.out.println("所有商品庫存總價值合計為：" + totalValue + " 元\n");
    }

    public static int findProductIndexByName(Product[] products, int count, String searchName) {
        String cleanSearch = searchName.trim().toLowerCase();
        for (int i = 0; i < count; i++) {
            if (products[i].getName().toLowerCase().equals(cleanSearch)) {
                return i;
            }
        }
        return -1;
    }

    public static void printOperationSummary(int purchaseCount, int restockCount) {
        System.out.println("\n=== 系統操作摘要 ===");
        System.out.println("1. 成功出售商品次數：" + purchaseCount + " 次");
        System.out.println("2. 成功完成補貨次數：" + restockCount + " 次");
        System.out.println("商品管理系統已安全關閉。");
    }
}