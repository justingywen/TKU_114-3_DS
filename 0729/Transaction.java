public class Transaction {
    private String txId;
    private String account;
    private int amount;
    private int timeSeq;

    public Transaction(String txId, String account, int amount, int timeSeq) {
        this.txId = txId;
        this.account = account;
        this.amount = amount;
        this.timeSeq = timeSeq;
    }

    public int getAmount() { return amount; }
    public int getTimeSeq() { return timeSeq; }

    @Override
    public String toString() {
        return String.format("交易編號: %s | 帳號: %s | 金額: %5d | 時間序號: %d", txId, account, amount, timeSeq);
    }
}