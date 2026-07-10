public class SubtotalCalculator {
    public static void main(String[] args) {
        int result1 = calculateSubtotal(30, 3);
        int result2 = calculateSubtotal(50, 2);

        System.out.println("小計 1: " + result1);
        System.out.println("小計 2: " + result2);
    }

    public static int calculateSubtotal(int price, int quantity) {
        int subtotal = price * quantity;
        return subtotal;
    }
}