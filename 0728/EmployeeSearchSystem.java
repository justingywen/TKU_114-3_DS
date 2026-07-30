public class EmployeeSearchSystem {
    public static void main(String[] args) {
        // 資料庫必須依序已完成員工編號排序
        Employee[] employees = {
            new Employee(1001, "張忠謀", "研發部", "301"),
            new Employee(1005, "林百里", "業務部", "205"),
            new Employee(1010, "蔡明介", "行銷部", "118"),
            new Employee(1024, "施振榮", "公關部", "409")
        };

        // 測試查詢成功
        printSearchResult(employees, 1010);
        // 測試查無資料
        printSearchResult(employees, 9999);
        // 測試空資料陣列查詢
        printSearchResult(new Employee[]{}, 1001);
    }

    public static Employee binarySearchEmployee(Employee[] employees, int targetId) {
        int low = 0;
        int high = employees.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int currentId = employees[mid].getId();

            if (currentId == targetId) {
                return employees[mid];
            } else if (targetId < currentId) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static void printSearchResult(Employee[] employees, int targetId) {
        Employee emp = binarySearchEmployee(employees, targetId);
        if (emp != null) {
            System.out.println("查詢結果：\n -> " + emp);
        } else {
            System.out.printf("查詢結果：找不到編號 [%d] 的員工。%n", targetId);
        }
    }
}