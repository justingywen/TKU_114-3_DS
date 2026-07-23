import java.util.ArrayList;

public class NameListManager {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        // 測試新增
        addName(names, "Alice");
        addName(names, "Bob");
        addName(names, "   "); // 測試空白防呆

        // 測試搜尋與修改
        System.out.println("搜尋 'alice': " + findNameIndex(names, "alice")); // 應為 0
        updateName(names, "alice", "Alice Smith");

        // 測試刪除
        removeName(names, "Bob");
        removeName(names, "Charlie"); // 測試刪除不存在的人

        System.out.println("\n最終名單：");
        printAll(names);
    }

    public static void addName(ArrayList<String> names, String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("新增失敗：姓名不可為空白。");
            return;
        }
        names.add(name.trim());
        System.out.println("成功新增：" + name.trim());
    }

    public static int findNameIndex(ArrayList<String> names, String target) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void updateName(ArrayList<String> names, String oldName, String newName) {
        int index = findNameIndex(names, oldName);
        if (index != -1 && newName != null && !newName.trim().isEmpty()) {
            names.set(index, newName.trim());
            System.out.println("修改成功：" + oldName + " -> " + newName.trim());
        } else {
            System.out.println("修改失敗：找不到目標或新姓名為空白。");
        }
    }

    public static void removeName(ArrayList<String> names, String name) {
        int index = findNameIndex(names, name);
        if (index != -1) {
            names.remove(index);
            System.out.println("刪除成功：" + name);
        } else {
            System.out.println("刪除失敗：找不到 " + name);
        }
    }

    public static void printAll(ArrayList<String> names) {
        if (names.isEmpty()) {
            System.out.println("名單為空。");
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println((i + 1) + ". " + names.get(i));
        }
    }
}
