import java.util.ArrayList;

public class ContactBookSystem {
    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();

        addContact(contacts, new Contact("C01", "Amy", "0912345678", "amy@test.com"));
        addContact(contacts, new Contact("C02", "Ben", "0987654321", "ben@test.com"));
        addContact(contacts, new Contact("C01", "Cara", "0900000000", "cara@test.com")); // 代碼重複
        addContact(contacts, new Contact("C03", "  ", "0900000000", "")); // 空白姓名

        updatePhone(contacts, "C02", "0999999999");
        removeContact(contacts, "C01");

        System.out.println("\n--- 完整聯絡人清單 ---");
        printAllContacts(contacts);
    }

    // Method 1: 搜尋
    public static Contact findContact(ArrayList<Contact> contacts, String code) {
        for (Contact c : contacts) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return null;
    }

    // Method 2: 新增
    public static void addContact(ArrayList<Contact> contacts, Contact newContact) {
        if (newContact.getName() == null || newContact.getName().trim().isEmpty()) {
            System.out.println("新增失敗：姓名不可為空白。");
            return;
        }
        if (findContact(contacts, newContact.getCode()) != null) {
            System.out.println("新增失敗：代碼 " + newContact.getCode() + " 已存在。");
            return;
        }
        contacts.add(newContact);
        System.out.println("成功新增聯絡人：" + newContact.getName());
    }

    // Method 3: 修改
    public static void updatePhone(ArrayList<Contact> contacts, String code, String newPhone) {
        Contact target = findContact(contacts, code);
        if (target != null) {
            target.setPhone(newPhone);
            System.out.println("電話修改成功：" + target.getName());
        } else {
            System.out.println("修改失敗：找不到聯絡人。");
        }
    }

    // Method 4: 刪除
    public static boolean removeContact(ArrayList<Contact> contacts, String code) {
        Contact target = findContact(contacts, code);
        if (target != null) {
            contacts.remove(target);
            System.out.println("成功刪除聯絡人：" + target.getName());
            return true;
        }
        System.out.println("刪除失敗：找不到聯絡人。");
        return false;
    }

    // Method 5: 顯示全部
    public static void printAllContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("通訊錄目前沒有資料。");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}