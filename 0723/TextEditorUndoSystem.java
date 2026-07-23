import java.util.ArrayDeque;
import java.util.Deque;

public class TextEditorUndoSystem {
    private String content = "";
    private Deque<String> history = new ArrayDeque<>();

    public void addText(String text) {
        history.push(content);
        content += text;
        System.out.println("新增文字後：[" + content + "]");
    }

    public void deleteLast(int count) {
        history.push(content);
        
        if (count >= content.length()) {
            content = "";
        } else {
            content = content.substring(0, content.length() - count);
        }
        System.out.println("刪除 " + count + " 字元後：[" + content + "]");
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("Undo 失敗：沒有歷史紀錄可供還原。");
            return;
        }
        content = history.pop();
        System.out.println("Undo 成功：[" + content + "]");
    }

    public void printContent() {
        System.out.println("目前完整內容：[" + content + "]");
    }

    public static void main(String[] args) {
        TextEditorUndoSystem editor = new TextEditorUndoSystem();

        System.out.println("--- 編輯階段 ---");
        editor.addText("Java");
        editor.addText(" Stack");
        editor.addText(" and Queue");
        editor.deleteLast(6);
        editor.addText(" Deque");

        editor.printContent();

        System.out.println("\n--- 連續 Undo 階段 ---");
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();
        editor.undo();
    }
}