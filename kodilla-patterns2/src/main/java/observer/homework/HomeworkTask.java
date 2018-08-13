package observer.homework;

public class HomeworkTask {
    private String module;
    private String studentName;
    private boolean isAccepted;

    public HomeworkTask(String module, String studentName) {
        this.module = module;
        this.studentName = studentName;
    }

    public String getModule() {
        return module;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
