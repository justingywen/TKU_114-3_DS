import java.util.Scanner;

public class SimpleMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("執行功能 1\n");
                    break;
                case 2:
                    System.out.println("執行功能 2\n");
                    break;
                case 0:
                    System.out.println("已離開系統。");
                    break;
                default:
                    System.out.println("無效選項，請重新輸入！\n");
                    break;
            }
        }

        scanner.close();
    }

    public static void printMenu() {
        System.out.println("=== 系統選單 ===");
        System.out.println("1：功能一");
        System.out.println("2：功能二");
        System.out.println("0：離開");
        System.out.print("請輸入選項：");
    }
}