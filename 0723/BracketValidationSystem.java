import java.util.ArrayDeque;
import java.util.Deque;

public class BracketValidationSystem {
    public static void main(String[] args) {
        System.out.println("測試 1 (正常巢狀) a(b[c]d){e} : " + isValid("a(b[c]d){e}"));
        System.out.println("測試 2 (順序錯誤) ([)] : " + isValid("([)]"));
        System.out.println("測試 3 (缺少右括號) ([]{ : " + isValid("([]{"));
        System.out.println("測試 4 (缺少左括號) )[]{} : " + isValid(")[]{}"));
        System.out.println("測試 5 (純文字無括號) Hello : " + isValid("Hello"));
    }

    public static boolean isValid(String text) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (isLeftBracket(ch)) {
                stack.push(ch);
            } else if (isRightBracket(ch)) {
                if (stack.isEmpty()) {
                    return false; 
                }
                char top = stack.pop();
                if (!isMatching(top, ch)) {
                    return false; 
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isRightBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean isMatching(char left, char right) {
        return (left == '(' && right == ')') ||
               (left == '[' && right == ']') ||
               (left == '{' && right == '}');
    }
}