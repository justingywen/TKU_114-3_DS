import java.util.Scanner;

public class ProductIdSearchPractice {
    public static void main(String[] args) {
        int[] productIds = {305, 102, 440, 218, 509, 102, 991, 804};
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要搜尋的商品編號: ");
        int target = scanner.nextInt();

        int comparisons = 0;
        int foundIndex = -1;

        for (int i = 0; i < productIds.length; i++) {
            comparisons++;
            if (productIds[i] == target) {
                foundIndex = i;
                break; // 找到第一筆便跳出
            }
        }

        if (foundIndex != -1) {
            System.out.printf("商品 %d：已找到，索引為 %d%n", target, foundIndex);
        } else {
            System.out.printf("商品 %d：找不到%n", target);
        }
        System.out.println("實際比較次數：" + comparisons);
        scanner.close();
    }
}