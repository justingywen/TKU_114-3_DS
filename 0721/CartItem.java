public class CartItem {
    private String code;
    private String name;
    private double price;
    private int quantity;

    public CartItem(String code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = Math.max(price, 0);
        this.quantity = Math.max(quantity, 1);
    }

    public String getCode() { return code; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return price * quantity; }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    @Override
    public String toString() {
        return code + " | " + name + " | 單價: " + price + " | 數量: " + quantity + " | 小計: " + getSubtotal();
    }
}