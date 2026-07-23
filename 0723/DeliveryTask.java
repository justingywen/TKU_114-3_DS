public class DeliveryTask {
    private String taskId;
    private String destination;

    public DeliveryTask(String taskId, String destination) {
        this.taskId = taskId;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return taskId + " (" + destination + ")";
    }
}