import java.util.Scanner;

public class AtmMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int balance = 1000;
        int choice = -1;

        while (choice != 0) {
            System.out.println("=== ATM 系統 ===");
            System.out.println("1：查詢餘額");
            System.out.println("2：存款");
            System.out.println("3：提款");
            System.out.println("0：離開");
            System.out.print("請輸入選項：");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("目前帳戶餘額為：" + balance + " 元\n");
                    break;

                case 2:
                    int depositAmount = 0;
                    while (depositAmount <= 0) {
                        System.out.print("請輸入存款金額：");
                        depositAmount = scanner.nextInt();
                        if (depositAmount <= 0) {
                            System.out.println("錯誤：存款金額必須大於 0，請重新輸入！");
                        }
                    }
                    balance = balance + depositAmount;
                    System.out.println("存款成功！已存入 " + depositAmount + " 元。目前餘額：" + balance + " 元\n");
                    break;

                case 3:
                    int withdrawAmount = 0;
                    while (withdrawAmount <= 0 || withdrawAmount > balance) {
                        System.out.print("請輸入提款金額：");
                        withdrawAmount = scanner.nextInt();
                        if (withdrawAmount <= 0) {
                            System.out.println("錯誤：提款金額必須大於 0，請重新輸入！");
                        } else if (withdrawAmount > balance) {
                            System.out.println("錯誤：提款金額不能大於目前餘額（目前餘額：" + balance + " 元），請重新輸入！");
                        }
                    }
                    balance = balance - withdrawAmount;
                    System.out.println("提款成功！已吐鈔 " + withdrawAmount + " 元。目前餘額：" + balance + " 元\n");
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
}