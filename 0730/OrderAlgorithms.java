import java.util.ArrayList;

public class OrderAlgorithms {

    public static void mergeSortByAmountDesc(Order[] orders) {
        if (orders == null || orders.length < 2) return;
        Order[] temp = new Order[orders.length];
        mergeSortByAmountDesc(orders, temp, 0, orders.length - 1);
    }

    private static void mergeSortByAmountDesc(Order[] orders, Order[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortByAmountDesc(orders, temp, left, mid);
        mergeSortByAmountDesc(orders, temp, mid + 1, right);
        mergeAmountDesc(orders, temp, left, mid, right);
    }

    private static void mergeAmountDesc(Order[] orders, Order[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (orders[i].getAmount() >= orders[j].getAmount()) {
                temp[k++] = orders[i++];
            } else {
                temp[k++] = orders[j++];
            }
        }
        while (i <= mid) temp[k++] = orders[i++];
        while (j <= right) temp[k++] = orders[j++];

        for (int index = left; index <= right; index++) {
            orders[index] = temp[index];
        }
    }

    public static ArrayList<Order> findByCustomer(ArrayList<Order> orders, String customer) {
        ArrayList<Order> result = new ArrayList<>();
        if (orders == null || customer == null) return result;
        for (Order order : orders) {
            if (order.getCustomer().equalsIgnoreCase(customer.trim())) {
                result.add(order);
            }
        }
        return result;
    }

    public static boolean containsId(ArrayList<Order> orders, String id) {
        if (orders == null || id == null) return false;
        for (Order order : orders) {
            if (order.getId().equalsIgnoreCase(id.trim())) {
                return true;
            }
        }
        return false;
    }
}