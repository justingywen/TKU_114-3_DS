public class ContestRankingSystem {
    public static void main(String[] args) {
        Contestant[] contestants = {
            new Contestant("C01", "Alice", 85, 120),
            new Contestant("C02", "Bob", 90, 110),
            new Contestant("C03", "Charlie", 85, 115),
            new Contestant("C04", "David", 90, 105),
            new Contestant("C05", "Eve", 75, 130)
        };

        insertionSort(contestants);

        System.out.println("名次 | 編號 | 姓名     | 分數   | 秒數");
        System.out.println("----------------------------------------");
        for (int i = 0; i < contestants.length; i++) {
            System.out.printf(" %2d  | %s%n", i + 1, contestants[i]);
        }
    }

    public static void insertionSort(Contestant[] arr) {
        for (int index = 1; index < arr.length; index++) {
            Contestant key = arr[index];
            int position = index - 1;

            while (position >= 0 && 
                  (arr[position].getScore() < key.getScore() || 
                  (arr[position].getScore() == key.getScore() && arr[position].getSeconds() > key.getSeconds()))) {
                arr[position + 1] = arr[position];
                position--;
            }
            arr[position + 1] = key;
        }
    }
}