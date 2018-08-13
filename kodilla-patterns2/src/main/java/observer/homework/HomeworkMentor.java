package observer.homework;

import java.util.List;

public class HomeworkMentor implements HomeworkObserver {
    private final String mentorName;
    private int updateCount;
    private List<HomeworkTask> homeworkTasks;

    public HomeworkMentor(String mentorName) {
        this.mentorName = mentorName;
    }

    public void update()
    public int getUpdateCount() {
        return updateCount;
    }
}
