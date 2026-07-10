package week1_practice;

import java.util.Scanner;

public class AtmSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 初始狀態
        int balance = 1000;
        int choice = -1;
        
        // 統計計數器與累加器
        int depositCount = 0;
        int withdrawCount = 0;
        int totalDeposit = 0;
        int totalWithdraw = 0;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    printBalance(balance);
                    break;

                case 2:
                    int depAmount = readPositiveAmount(scanner, "請輸入存款金額：");
                    balance = deposit(balance, depAmount);
                    
                    // 更新存款統計
                    depositCount++;
                    totalDeposit = totalDeposit + depAmount;
                    
                    printBalance(balance);
                    break;

                case 3:
                    int wdAmount = readPositiveAmount(scanner, "請輸入提款金額：");
                    
                    // 呼叫 boolean 判斷方法檢查餘額是否足夠
                    if (canWithdraw(balance, wdAmount)) {
                        balance = withdraw(balance, wdAmount);
                        
                        // 更新提款統計
                        withdrawCount++;
                        totalWithdraw = totalWithdraw + wdAmount;
                        
                        printBalance(balance);
                    } else {
                        System.out.println("錯誤：提款金額不能超過目前餘額！\n");
                    }
                    break;

                case 4:
                    // 隨時查看當前統計摘要
                    printSummary(balance, depositCount, withdrawCount, totalDeposit, totalWithdraw);
                    break;

                case 0:
                    System.out.println("感謝您的使用，再見！");
                    break;

                default:
                    System.out.println("錯誤：無效選項，請重新輸入！\n");
                    break;
            }
        }

        // 離開時強制輸出最終完整摘要
        printSummary(balance, depositCount, withdrawCount, totalDeposit, totalWithdraw);
        
        scanner.close();
    }

    // 顯示功能選單介面
    public static void printMenu() {
        System.out.println("=== ATM Menu ===");
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Show summary");
        System.out.println("0. Exit");
        System.out.print("請輸入選項：");
    }

    // 讀取合法金額（必須大於 0）
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

    // 處理存款，回傳新餘額
    public static int deposit(int balance, int amount) {
        return balance + amount;
    }

    // 處理提款，回傳新餘額
    public static int withdraw(int balance, int amount) {
        return balance - amount;
    }

    // 檢查提款金額是否小於或等於當前餘額
    public static boolean canWithdraw(int balance, int amount) {
        return amount <= balance;
    }

    // 印出目前餘額資訊
    public static void printBalance(int balance) {
        System.out.println("Balance: " + balance + "\n");
    }

    // 印出包含最終餘額、次數、總額的完整摘要
    public static void printSummary(int balance, int depositCount, int withdrawCount, int totalDeposit, int totalWithdraw) {
        System.out.println("\n=== ATM Summary ===");
        System.out.println("Final balance: " + balance);
        System.out.println("Deposit count: " + depositCount);
        System.out.println("Withdraw count: " + withdrawCount);
        System.out.println("Total deposit: " + totalDeposit);
        System.out.println("Total withdraw: " + totalWithdraw);
        System.out.println();
    }
}