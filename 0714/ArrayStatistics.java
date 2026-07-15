
import java.util.Scanner;

public class ArrayStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = readCount(scanner);
        int[] scores = new int[count];

        inputScores(scanner, scores);

        System.out.print("\n全部成績：");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + (i == scores.length - 1 ? "" : ", "));
        }
        System.out.println();

        int total = calculateTotal(scores);
        double average = (double) total / scores.length;
        int max = findMax(scores);
        int min = findMin(scores);
        int passCount = countPass(scores);
        int failCount = scores.length - passCount;

        System.out.println("=== 統計結果 ===");
        System.out.println("總分：" + total);
        System.out.printf("平均：%.2f\n", average);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
        System.out.println("及格人數：" + passCount);
        System.out.println("不及格人數：" + failCount);

        System.out.print("\n請輸入要搜尋的目標成績：");
        int target = scanner.nextInt();
        int index = findIndex(scores, target);

        if (index != -1) {
            System.out.println("成績 " + target + " 第一次出現在索引：" + index);
        } else {
            System.out.println("找不到成績為 " + target + " 的資料。");
        }

        scanner.close();
    }

    public static int readCount(Scanner sc) {
        int count = 0;
        while (count < 1 || count > 50) {
            System.out.print("請輸入學生成績筆數 (1~50)：");
            count = sc.nextInt();
            if (count < 1 || count > 50) {
                System.out.println("錯誤：筆數必須在 1 到 50 之間，請重新輸入！");
            }
        }
        return count;
    }

    public static void inputScores(Scanner sc, int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            int score = -1;
            while (score < 0 || score > 100) {
                System.out.print("請輸入第 " + (i + 1) + " 筆成績 (0~100)：");
                score = sc.nextInt();
                if (score < 0 || score > 100) {
                    System.out.println("錯誤：成績範圍必須在 0 到 100 之間，請重新輸入！");
                }
            }
            scores[i] = score;
        }
    }

    public static int calculateTotal(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    public static int countPass(int[] scores) {
        int count = 0;
        for (int score : scores) {
            if (score >= 60) {
                count++;
            }
        }
        return count;
    }

    public static int findIndex(int[] scores, int target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                return i;
            }
        }
        return -1;
    }
}