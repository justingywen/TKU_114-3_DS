public class TaskLinkedListSystem {
    public static void main(String[] args) {
        TaskLinkedList taskManager = new TaskLinkedList();

        taskManager.addNormalTask("T01", "整理報表");
        taskManager.addNormalTask("T02", "回覆客戶信件");
        taskManager.addUrgentTask("T03", "伺服器異常修復");

        System.out.println();
        taskManager.printUncompletedTasks();

        System.out.println("\n--- 狀態更新與刪除 ---");
        taskManager.completeTask("T03"); 
        taskManager.completeTask("T99"); 
        taskManager.removeTask("T01");   

        System.out.println();
        taskManager.printUncompletedTasks();
    }
}