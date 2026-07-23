import java.util.ArrayList;

public class EquipmentManager {
    public static void main(String[] args) {
        ArrayList<Equipment> equipments = new ArrayList<>();

        addEquipment(equipments, new Equipment("E01", "投影機"));
        addEquipment(equipments, new Equipment("E02", "筆記型電腦"));
        addEquipment(equipments, new Equipment("E01", "麥克風")); // 測試重複代碼

        borrowEquipment(equipments, "E01");
        borrowEquipment(equipments, "E01"); // 測試重複借出
        
        System.out.println("\n--- 目前可借用設備 ---");
        listAvailable(equipments);

        returnEquipment(equipments, "E01");
        
        System.out.println("\n--- 歸還後全部設備 ---");
        for (Equipment eq : equipments) {
            System.out.println(eq);
        }
    }

    public static Equipment findByCode(ArrayList<Equipment> equipments, String code) {
        for (Equipment eq : equipments) {
            if (eq.getCode().equalsIgnoreCase(code)) {
                return eq;
            }
        }
        return null;
    }

    public static void addEquipment(ArrayList<Equipment> equipments, Equipment newEq) {
        if (findByCode(equipments, newEq.getCode()) != null) {
            System.out.println("新增失敗：代碼 " + newEq.getCode() + " 已存在！");
        } else {
            equipments.add(newEq);
            System.out.println("成功新增設備：" + newEq.getName());
        }
    }

    public static void borrowEquipment(ArrayList<Equipment> equipments, String code) {
        Equipment eq = findByCode(equipments, code);
        if (eq == null) {
            System.out.println("借出失敗：找不到代碼 " + code);
        } else if (!eq.isAvailable()) {
            System.out.println("借出失敗：" + eq.getName() + " 已被借出！");
        } else {
            eq.borrow();
            System.out.println("成功借出：" + eq.getName());
        }
    }

    public static void returnEquipment(ArrayList<Equipment> equipments, String code) {
        Equipment eq = findByCode(equipments, code);
        if (eq == null) {
            System.out.println("歸還失敗：找不到代碼 " + code);
        } else {
            eq.returnEq();
            System.out.println("成功歸還：" + eq.getName());
        }
    }

    public static void listAvailable(ArrayList<Equipment> equipments) {
        for (Equipment eq : equipments) {
            if (eq.isAvailable()) {
                System.out.println(eq);
            }
        }
    }
}