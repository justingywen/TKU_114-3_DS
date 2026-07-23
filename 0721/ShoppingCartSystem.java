import java.util.ArrayList;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        ArrayList<CartItem> cart = new ArrayList<>();

        addItem(cart, new CartItem("P01", "滑鼠", 500, 1));
        addItem(cart, new CartItem("P02", "鍵盤", 1200, 1));
        addItem(cart, new CartItem("P01", "滑鼠", 500, 2)); // 重複加入，應合併數量

        updateQuantity(cart, "P02", 0); // 測試無效更新
        updateQuantity(cart, "P02", 3); // 測試有效更新

        removeItem(cart, "P99"); // 測試移除不存在商品
        
        System.out.println("\n--- 購物車明細 ---");
        for (CartItem item : cart) {
            System.out.println(item);
        }
        System.out.println("總金額：" + calculateTotal(cart));
    }

    public static CartItem findItem(ArrayList<CartItem> cart, String code) {
        for (CartItem item : cart) {
            if (item.getCode().equalsIgnoreCase(code)) {
                return item;
            }
        }
        return null;
    }

    public static void addItem(ArrayList<CartItem> cart, CartItem newItem) {
        CartItem existing = findItem(cart, newItem.getCode());
        if (existing != null) {
            existing.addQuantity(newItem.getQuantity());
            System.out.println("商品已存在，數量增加為：" + existing.getQuantity());
        } else {
            cart.add(newItem);
            System.out.println("已加入新商品：" + newItem.getCode());
        }
    }

    public static void updateQuantity(ArrayList<CartItem> cart, String code, int newQty) {
        if (newQty <= 0) {
            System.out.println("更新失敗：數量必須大於 0。若要刪除請使用移除功能。");
            return;
        }
        CartItem item = findItem(cart, code);
        if (item != null) {
            item.setQuantity(newQty);
            System.out.println("數量已更新為：" + newQty);
        } else {
            System.out.println("更新失敗：找不到該商品。");
        }
    }

    public static void removeItem(ArrayList<CartItem> cart, String code) {
        CartItem item = findItem(cart, code);
        if (item != null) {
            cart.remove(item);
            System.out.println("已移除商品：" + code);
        } else {
            System.out.println("移除失敗：找不到該商品。");
        }
    }

    public static double calculateTotal(ArrayList<CartItem> cart) {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getSubtotal();
        }
        return total;
    }
}