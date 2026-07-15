public class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "Unknown Product";
        } else {
            this.name = name.trim();
        }

        if (price > 0) {
            this.price = price;
        } else {
            this.price = 1;
        }

        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getStock() {
        return this.stock;
    }

    public boolean setPrice(int price) {
        if (price > 0) {
            this.price = price;
            return true;
        }
        return false;
    }

    public boolean restock(int amount) {
        if (amount > 0) {
            this.stock += amount;
            return true;
        }
        return false;
    }

    public boolean sell(int amount) {
        if (amount > 0 && amount <= this.stock) {
            this.stock -= amount;
            return true;
        }
        return false;
    }

    public boolean isLowStock() {
        return this.stock < 10;
    }

    public int getInventoryValue() {
        return this.price * this.stock;
    }

    @Override
    public String toString() {
        return "Product[Name=" + this.name + ", Price=" + this.price + ", Stock=" + this.stock + "]";
    }
}