import java.util.Scanner;

public class AtmMenuRefactored {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 1000;
        int choice = -1;

        while (choice != 0) {
            printAtmMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("目前帳戶餘額為：" + balance + " 元\n");
                    break;
                case 2:
                    int depositAmount = readValidDeposit(scanner);
                    balance = deposit(balance, depositAmount);
                    break;
                case 3:
                    int withdrawAmount = readValidWithdraw(scanner, balance);
                    balance = withdraw(balance, withdrawAmount);
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

    public static void printAtmMenu() {
        System.out.println("=== ATM 系統 ===");
        System.out.println("1：查詢餘額");
        System.out.println("2：存款");
        System.out.println("3：提款");
        System.out.println("0：離開");
        System.out.print("請輸入選項：");
    }

    public static int readValidDeposit(Scanner scanner) {
        int amount = 0;
        while (amount <= 0) {
            System.out.print("請輸入存款金額：");
            amount = scanner.nextInt();
            if (amount <= 0) {
                System.out.println("錯誤：存款金額必須大於 0，請重新輸入！");
            }
        }
        return amount;
    }

    public static int readValidWithdraw(Scanner scanner, int currentBalance) {
        int amount = 0;
        while (amount <= 0 || amount > currentBalance) {
            System.out.print("請輸入提款金額：");
            amount = scanner.nextInt();
            if (amount <= 0) {
                System.out.println("錯誤：提款金額必須大於 0，請重新輸入！");
            } else if (amount > currentBalance) {
                System.out.println("錯誤：提款金額不能大於目前餘額（目前餘額：" + currentBalance + " 元），請重新輸入！");
            }
        }
        return amount;
    }

    public static int deposit(int currentBalance, int amount) {
        int newBalance = currentBalance + amount;
        System.out.println("存款成功！已存入 " + amount + " 元。目前餘額：" + newBalance + " 元\n");
        return newBalance;
    }

    public static int withdraw(int currentBalance, int amount) {
        int newBalance = currentBalance - amount;
        System.out.println("提款成功！已吐鈔 " + amount + " 元。目前餘額：" + newBalance + " 元\n");
        return newBalance;
    }
}