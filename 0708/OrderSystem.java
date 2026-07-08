import java.util.Scanner;

public class OrderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int choice = -1;
        int totalItems = 0;
        int totalAmount = 0;

        while (choice != 0) {
            System.out.println("=== Order Menu ===");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");
            System.out.print("請輸入選項：");
            
            choice = scanner.nextInt();

            int price = 0;
            boolean validOrder = true;

            switch (choice) {
                case 1:
                    price = 30;
                    break;
                case 2:
                    price = 35;
                    break;
                case 3:
                    price = 50;
                    break;
                case 0:
                    validOrder = false;
                    break;
                default:
                    System.out.println("無效選項，請重新輸入！\n");
                    validOrder = false;
                    break;
            }

            if (validOrder) {
                int quantity = 0;
                while (quantity <= 0) {
                    System.out.print("請輸入數量：");
                    quantity = scanner.nextInt();
                    if (quantity <= 0) {
                        System.out.println("錯誤：數量必須大於 0，請重新輸入！");
                    }
                }

                int subtotal = price * quantity;
                System.out.println("Subtotal: " + subtotal + "\n");

                totalItems = totalItems + quantity;
                totalAmount = totalAmount + subtotal;
            }
        }

        System.out.println("\n=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);

        scanner.close();
    }
}