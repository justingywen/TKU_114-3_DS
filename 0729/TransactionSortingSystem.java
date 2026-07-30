public class TransactionSortingSystem {
    public static void main(String[] args) {
        Transaction[] txs = {
            new Transaction("T01", "A123", 5000, 3),
            new Transaction("T02", "B456", 12000, 1),
            new Transaction("T03", "C789", 5000, 2),
            new Transaction("T04", "D012", 8000, 4),
            new Transaction("T05", "E345", 12000, 5)
        };

        System.out.println("【排序前】");
        for (Transaction t : txs) System.out.println(t);

        for (int i = 1; i < txs.length; i++) {
            Transaction key = txs[i];
            int j = i - 1;
            while (j >= 0 && 
                  (txs[j].getAmount() < key.getAmount() || 
                  (txs[j].getAmount() == key.getAmount() && txs[j].getTimeSeq() > key.getTimeSeq()))) {
                txs[j + 1] = txs[j];
                j--;
            }
            txs[j + 1] = key;
        }

        System.out.println("\n【排序後 (金額降冪，相同金額依時間序號升冪)】");
        for (Transaction t : txs) System.out.println(t);
    }
}