public class ProductSortPractice {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P01", "筆電", 35000, 10),
            new Product("P02", "滑鼠", 500, 50),
            new Product("P03", "鍵盤", 1200, 30),
            new Product("P04", "耳機", 1200, 15),
            new Product("P05", "螢幕", 5000, 20),
            new Product("P06", "隨身碟", 500, 100),
            new Product("P07", "硬碟", 2000, 40),
            new Product("P08", "平板", 15000, 25)
        };

        for (int index = 1; index < products.length; index++) {
            Product key = products[index];
            int position = index - 1;

            while (position >= 0 && products[position].getPrice() > key.getPrice()) {
                products[position + 1] = products[position];
                position--;
            }
            products[position + 1] = key;
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }
}

class Product {
    private String id;
    private String name;
    private int price;
    private int stock;

    public Product(String id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("編號: %s | 名稱: %s | 價格: $%d | 庫存: %d", id, name, price, stock);
    }
}