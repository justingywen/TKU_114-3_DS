import java.util.Scanner;

public class ScoreReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 使用者輸入區：從鍵盤讀取學生姓名與三科成績
        System.out.print("請輸入姓名：");
        String name = scanner.next();

        System.out.print("請輸入 Java 成績：");
        int javaScore = scanner.nextInt();

        System.out.print("請輸入 English 成績：");
        int englishScore = scanner.nextInt();

        System.out.print("請輸入 Math 成績：");
        int mathScore = scanner.nextInt();

        // 運算區：將三科成績加總並除以 3.0 以取得精準的平均小數點
        double average = (javaScore + englishScore + mathScore) / 3.0;

        System.out.println("\n=== 成績報表 ===");
        System.out.println("姓名：" + name);
        System.out.println("Java：" + javaScore);
        System.out.println("English：" + englishScore);
        System.out.println("Math：" + mathScore);
        System.out.println("平均：" + average);

        scanner.close();
    }
}