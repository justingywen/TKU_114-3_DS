import java.util.Scanner;

public class OrderSystemRefactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int choice = -1;
        int totalItems = 0;
        int totalAmount = 0;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();

            if (choice == 1 || choice == 2 || choice == 3) {
                int price = getPrice(choice);
                int quantity = readValidQuantity(scanner);
                int subtotal = calculateSubtotal(price, quantity);
                
                System.out.println("Subtotal: " + subtotal + "\n");

                totalItems = totalItems + quantity;
                totalAmount = totalAmount + subtotal;
            } else if (choice != 0) {
                System.out.println("無效選項，請重新輸入！\n");
            }
        }

        printReceipt(totalItems, totalAmount);
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=== Order Menu ===");
        System.out.println("1. Black tea  $30");
        System.out.println("2. Green tea  $35");
        System.out.println("3. Coffee     $50");
        System.out.println("0. Checkout");
        System.out.print("請輸入選項：");
    }

    public static int getPrice(int option) {
        switch (option) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 50;
            default:
                return 0;
        }
    }

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

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static void printReceipt(int totalItems, int totalAmount) {
        System.out.println("\n=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);
    }
}