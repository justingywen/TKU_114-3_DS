
import java.util.Scanner;

public class SalesMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] sales = new int[3][4];

        inputSales(scanner, sales);
        printTable(sales);

        int[] productTotals = calculateProductTotals(sales);
        int[] dailyTotals = calculateDailyTotals(sales);

        printSummary(productTotals, dailyTotals);

        int topProductIndex = findBestProduct(productTotals);
        System.out.println("總銷售量最高的商品為：商品 " + (topProductIndex + 1) + " (總銷量：" + productTotals[topProductIndex] + ")");

        scanner.close();
    }

    public static void inputSales(Scanner sc, int[][] sales) {
        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                int value = -1;
                while (value < 0) {
                    System.out.print("請輸入商品 " + (i + 1) + " 第 " + (j + 1) + " 天的銷售量：");
                    value = sc.nextInt();
                    if (value < 0) {
                        System.out.println("錯誤：銷售量不得小於 0，請重新輸入！");
                    }
                }
                sales[i][j] = value;
            }
        }
    }

    public static void printTable(int[][] sales) {
        System.out.println("\n=== 銷售量報表 ===");
        System.out.println("\tDay 1\tDay 2\tDay 3\tDay 4");
        for (int i = 0; i < sales.length; i++) {
            System.out.print("商品 " + (i + 1));
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print("\t" + sales[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] calculateProductTotals(int[][] sales) {
        int[] totals = new int[sales.length];
        for (int i = 0; i < sales.length; i++) {
            int sum = 0;
            for (int j = 0; j < sales[i].length; j++) {
                sum += sales[i][j];
            }
            totals[i] = sum;
        }
        return totals;
    }

    public static int[] calculateDailyTotals(int[][] sales) {
        int[] totals = new int[sales[0].length];
        for (int j = 0; j < sales[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < sales.length; i++) {
                sum += sales[i][j];
            }
            totals[j] = sum;
        }
        return totals;
    }

    public static void printSummary(int[] productTotals, int[] dailyTotals) {
        System.out.println("\n=== 統計分析 ===");
        for (int i = 0; i < productTotals.length; i++) {
            System.out.println("商品 " + (i + 1) + " 銷售總量：" + productTotals[i]);
        }
        System.out.println("----------------");
        for (int j = 0; j < dailyTotals.length; j++) {
            System.out.println("第 " + (j + 1) + " 天全部商品銷售總量：" + dailyTotals[j]);
        }
        System.out.println("----------------");
    }

    public static int findBestProduct(int[] productTotals) {
        int maxIndex = 0;
        for (int i = 1; i < productTotals.length; i++) {
            if (productTotals[i] > productTotals[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}