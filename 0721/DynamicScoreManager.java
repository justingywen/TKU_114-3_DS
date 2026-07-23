import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("請輸入成績 (0-100)，輸入 -1 結束：");
        while (true) {
            System.out.print("成績：");
            int score = scanner.nextInt();

            if (score == -1) {
                break;
            }
            if (score < 0 || score > 100) {
                System.out.println("輸入無效，請輸入 0 到 100 之間的數值。");
                continue;
            }
            scores.add(score);
        }

        if (scores.isEmpty()) {
            System.out.println("沒有輸入任何成績！");
            return;
        }

        System.out.println("\n--- 成績統計 ---");
        System.out.println("總筆數：" + scores.size());
        System.out.println("平均：" + calculateAverage(scores));
        System.out.println("最高分：" + findMax(scores));
        System.out.println("最低分：" + findMin(scores));
        System.out.println("及格名單：" + getPassedScores(scores));
        
        scanner.close();
    }

    public static double calculateAverage(ArrayList<Integer> scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return (double) total / scores.size();
    }

    public static int findMax(ArrayList<Integer> scores) {
        int max = scores.get(0);
        for (int score : scores) {
            if (score > max) max = score;
        }
        return max;
    }

    public static int findMin(ArrayList<Integer> scores) {
        int min = scores.get(0);
        for (int score : scores) {
            if (score < min) min = score;
        }
        return min;
    }

    public static ArrayList<Integer> getPassedScores(ArrayList<Integer> scores) {
        ArrayList<Integer> passed = new ArrayList<>();
        for (int score : scores) {
            if (score >= 60) {
                passed.add(score);
            }
        }
        return passed;
    }
}
