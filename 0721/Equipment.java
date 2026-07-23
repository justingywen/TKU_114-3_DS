public class Equipment {
    private String code;
    private String name;
    private boolean isAvailable;

    public Equipment(String code, String name) {
        this.code = code;
        this.name = name;
        this.isAvailable = true; // 預設為可借用
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public boolean isAvailable() { return isAvailable; }

    public void borrow() { this.isAvailable = false; }
    public void returnEq() { this.isAvailable = true; }

    @Override
    public String toString() {
        String status = isAvailable ? "可借用" : "已借出";
        return code + " | " + name + " | 狀態: " + status;
    }
}