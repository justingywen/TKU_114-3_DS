
public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("101-001", "Alice", 1000);
        BankAccount acc2 = new BankAccount("101-002", "Bob", 500);

        System.out.println("=== 初始帳戶狀態 ===");
        System.out.println(acc1.toString());
        System.out.println(acc2.toString());
        System.out.println();

        System.out.println("=== 存款與提款測試 ===");
        boolean depSuccess = acc1.deposit(500);
        System.out.println("Alice 存款 500 結果：" + depSuccess + "，目前餘額：" + acc1.getBalance());

        boolean depFail = acc1.deposit(-100);
        System.out.println("Alice 存款 -100 結果：" + depFail + "，目前餘額：" + acc1.getBalance());

        boolean wdSuccess = acc2.withdraw(200);
        System.out.println("Bob 提款 200 結果：" + wdSuccess + "，目前餘額：" + acc2.getBalance());

        boolean wdFail = acc2.withdraw(1000);
        System.out.println("Bob 提款 1000 (超額) 結果：" + wdFail + "，目前餘額：" + acc2.getBalance());
        System.out.println();

        System.out.println("=== 轉帳測試 (成功) ===");
        boolean transferSuccess = acc1.transferTo(acc2, 400);
        System.out.println("Alice 轉帳 400 給 Bob 結果：" + transferSuccess);
        System.out.println("Alice " + acc1.toString());
        System.out.println("Bob " + acc2.toString());
        System.out.println();

        System.out.println("=== 轉帳測試 (失敗) ===");
        boolean transferFail = acc1.transferTo(acc2, 5000);
        System.out.println("Alice 轉帳 5000 (超額) 給 Bob 結果：" + transferFail);
        System.out.println("Alice " + acc1.toString());
        System.out.println("Bob " + acc2.toString());
        System.out.println();

        System.out.println("=== 轉帳測試 (防空值保護) ===");
        boolean transferNull = acc1.transferTo(null, 100);
        System.out.println("Alice 轉帳給無效帳戶 (null) 結果：" + transferNull);
        System.out.println("Alice " + acc1.toString());
    }
}