public class Contact {
    private String code;
    private String name;
    private String phone;
    private String email;

    public Contact(String code, String name, String phone, String email) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return code + " | " + name + " | " + phone + " | " + email;
    }
}