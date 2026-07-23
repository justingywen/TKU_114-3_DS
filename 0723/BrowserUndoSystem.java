import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserUndoSystem {
    public static void main(String[] args) {
        Deque<String> history = new ArrayDeque<>();
        String currentPage = "首頁 (Home)";

        System.out.println("--- 模擬瀏覽操作 ---");
        currentPage = openPage(history, currentPage, "課程列表");
        currentPage = openPage(history, currentPage, "Java 程式設計");
        currentPage = openPage(history, currentPage, "Stack 與 Queue");
        currentPage = openPage(history, currentPage, "作業說明");

        System.out.println("\n--- 模擬返回操作 ---");
        currentPage = goBack(history, currentPage);
        currentPage = goBack(history, currentPage);
        currentPage = goBack(history, currentPage);
        
        System.out.println("\n--- 邊界測試 ---");
        currentPage = goBack(history, currentPage);
        currentPage = goBack(history, currentPage);
    }

    public static String openPage(Deque<String> history, String currentPage, String newPage) {
        history.push(currentPage);
        System.out.println("開啟新頁面：" + newPage);
        return newPage;
    }

    public static String goBack(Deque<String> history, String currentPage) {
        if (history.isEmpty()) {
            System.out.println("無法返回：已經是第一頁了。目前頁面仍為 [" + currentPage + "]");
            return currentPage;
        }
        String previousPage = history.pop();
        System.out.println("返回上一頁：" + previousPage);
        return previousPage;
    }
}