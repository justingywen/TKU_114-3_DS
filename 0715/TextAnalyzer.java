import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = readValidText(scanner);

        System.out.println("\n=== 分析結果 ===");
        System.out.println("原始字元數：" + text.length());
        System.out.println("有效字元數 (去除首尾空白)：" + text.trim().length());

        String[] words = splitWords(text);
        System.out.println("單字數量：" + words.length);

        int vowelCount = countVowels(text);
        System.out.println("英文母音 (a, e, i, o, u) 總數：" + vowelCount);

        String longestWord = findLongestWord(words);
        System.out.println("最長單字：" + longestWord);

        System.out.print("\n請輸入要搜尋的關鍵字：");
        String keyword = scanner.next();
        int keywordCount = countKeyword(words, keyword);
        System.out.println("關鍵字 \"" + keyword + "\" 出現次數 (忽略大小寫)：" + keywordCount);

        scanner.close();
    }

    public static String readValidText(Scanner sc) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print("請輸入一行非空白文字：");
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("錯誤：輸入內容不能為空或全空白，請重新輸入！");
            }
        }
        return input;
    }

    public static String[] splitWords(String text) {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return new String[0];
        }
        return trimmed.split("\\s+");
    }

    public static int countVowels(String text) {
        int count = 0;
        String lowerText = text.toLowerCase();
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static String findLongestWord(String[] words) {
        if (words.length == 0) {
            return "";
        }
        String longest = words[0];
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public static int countKeyword(String[] words, String keyword) {
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(keyword)) {
                count++;
            }
        }
        return count;
    }
}