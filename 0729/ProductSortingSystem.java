public class ProductSortingSystem {
    public static void main(String[] args) {
        StoreProduct[] original = {
            new StoreProduct("P01", "Apple", 30, 100),
            new StoreProduct("P02", "Banana", 20, 150),
            new StoreProduct("P03", "Cherry", 50, 80),
            new StoreProduct("P04", "Date", 40, 120),
            new StoreProduct("P05", "Elderberry", 60, 50),
            new StoreProduct("P06", "Fig", 20, 200),
            new StoreProduct("P07", "Grape", 45, 90),
            new StoreProduct("P08", "Honeydew", 80, 30),
            new StoreProduct("P09", "Kiwi", 25, 110),
            new StoreProduct("P10", "Lemon", 15, 300)
        };

        System.out.println("【價格升冪排列 (Insertion Sort)】");
        StoreProduct[] priceAsc = original.clone();
        sortByPriceAsc(priceAsc);
        printArray(priceAsc);

        System.out.println("\n【價格降冪排列 (Selection Sort)】");
        StoreProduct[] priceDesc = original.clone();
        sortByPriceDesc(priceDesc);
        printArray(priceDesc);

        System.out.println("\n【庫存降冪排列 (Selection Sort)】");
        StoreProduct[] stockDesc = original.clone();
        sortByStockDesc(stockDesc);
        printArray(stockDesc);
    }

    public static void sortByPriceAsc(StoreProduct[] arr) {
        for (int i = 1; i < arr.length; i++) {
            StoreProduct key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getPrice() > key.getPrice()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void sortByPriceDesc(StoreProduct[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getPrice() > arr[maxIdx].getPrice()) maxIdx = j;
            }
            StoreProduct temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }

    public static void sortByStockDesc(StoreProduct[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].getStock() > arr[maxIdx].getStock()) maxIdx = j;
            }
            StoreProduct temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }

    public static void printArray(StoreProduct[] arr) {
        for (StoreProduct p : arr) System.out.println(p);
    }
}