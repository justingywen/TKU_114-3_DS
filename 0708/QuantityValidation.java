import java.util.Scanner;

public class QuantityValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int quantity = 0;

        while (quantity <= 0) {
            System.out.print("請輸入商品數量：");
            quantity = scanner.nextInt();

            if (quantity <= 0) {
                System.out.println("錯誤：數量必須大於 0，請重新輸入！\n");
            }
        }

        System.out.println("輸入成功！您設定的商品數量為：" + quantity);

        scanner.close();
    }
}