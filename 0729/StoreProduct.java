public class StoreProduct {
    private String id;
    private String name;
    private int price;
    private int stock;

    public StoreProduct(String id, String name, int price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getPrice() { return price; }
    public int getStock() { return stock; }

    @Override
    public String toString() {
        return String.format("%-4s %-12s 價格: $%d | 庫存: %d", id, name, price, stock);
    }
}