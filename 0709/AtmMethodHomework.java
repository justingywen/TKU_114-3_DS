import java.util.Scanner;

public class AtmMethodHomework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 1000;
        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printBalance(balance);
                    break;
                case 2:
                    int depositAmount = readPositiveAmount(scanner, "請輸入存款金額：");
                    balance = deposit(balance, depositAmount);
                    break;
                case 3:
                    int withdrawAmount = readPositiveAmount(scanner, "請輸入提款金額：");
                    if (withdrawAmount > balance) {
                        System.out.println("錯誤：提款金額不能大於目前餘額！\n");
                    } else {
                        balance = withdraw(balance, withdrawAmount);
                    }
                    break;
                case 0:
                    System.out.println("感謝您的使用，再見！");
                    break;
                default:
                    System.out.println("錯誤：無效選項，請重新輸入！\n");
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=== ATM 系統 ===");
        System.out.println("1：查詢餘額");
        System.out.println("2：存款");
        System.out.println("3：提款");
        System.out.println("0：離開");
        System.out.print("請輸入選項：");
    }

    public static int readPositiveAmount(Scanner sc, String message) {
        int amount = 0;
        while (amount <= 0) {
            System.out.print(message);
            amount = sc.nextInt();
            if (amount <= 0) {
                System.out.println("錯誤：金額必須大於 0，請重新輸入！");
            }
        }
        return amount;
    }

    public static int deposit(int balance, int amount) {
        int newBalance = balance + amount;
        System.out.println("存款成功！已存入 " + amount + " 元。\n");
        return newBalance;
    }

    public static int withdraw(int balance, int amount) {
        int newBalance = balance - amount;
        System.out.println("提款成功！已吐鈔 " + amount + " 元。\n");
        return newBalance;
    }

    public static void printBalance(int balance) {
        System.out.println("目前帳戶餘額為：" + balance + " 元\n");
    }
}