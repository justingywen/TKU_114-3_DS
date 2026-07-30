public class RecursiveNameSearchPractice {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve"};
        
        System.out.println("找 Charlie: 索引 " + search(names, "Charlie", 0));
        System.out.println("找 Alice (首筆): 索引 " + search(names, "Alice", 0));
        System.out.println("找 Eve (末筆): 索引 " + search(names, "Eve", 0));
        System.out.println("找 Frank (無此人): 索引 " + search(names, "Frank", 0));
        System.out.println("測試空陣列: 索引 " + search(new String[]{}, "Bob", 0));
    }

    public static int search(String[] names, String target, int index) {
        // Base case 1: 索引越界（含空陣列或找不到資料的情況）
        if (index >= names.length) {
            return -1;
        }
        // Base case 2: 字串比較必須用 equals
        if (names[index].equals(target)) {
            return index;
        }
        // Recursive case: 往陣列後方遞迴進階查詢
        return search(names, target, index + 1);
    }
}