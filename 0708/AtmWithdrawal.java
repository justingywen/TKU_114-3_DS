import java.util.Scanner;

public class AtmWithdrawal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String correctPassword = "1234";
        double balance = 50000.0;

        System.out.print("請輸入提款密碼：");
        String inputPassword = scanner.next();

        System.out.print("請輸入提款金額：");
        double withdrawAmount = scanner.nextDouble();

        System.out.println("\n=== ATM 處理中 ===");

        if (!inputPassword.equals(correctPassword)) {
            System.out.println("錯誤：密碼不正確，交易取消。");
        } else if (withdrawAmount > balance) {
            System.out.println("錯誤：帳戶餘額不足，交易取消。");
        } else {
            balance = balance - withdrawAmount;
            System.out.println("提款成功！請取回您的現金。");
            System.out.println("本次提款金額：" + withdrawAmount + " 元");
            System.out.println("更新後帳戶餘額：" + balance + " 元");
        }

        scanner.close();
    }
}