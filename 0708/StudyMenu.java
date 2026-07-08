import java.util.Scanner;

public class StudyMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("=== 學習選單 ===");
            System.out.println("1：輸出 Review Java");
            System.out.println("2：輸出 Practice loops");
            System.out.println("3：輸出 Push to GitHub");
            System.out.println("0：離開");
            System.out.print("請輸入選項：");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Review Java\n");
                    break;
                case 2:
                    System.out.println("Practice loops\n");
                    break;
                case 3:
                    System.out.println("Push to GitHub\n");
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
}