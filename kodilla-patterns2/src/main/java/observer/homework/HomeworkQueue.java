package observer.homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements Observable {
    private List<HomeworkTask> homeworkTasks;
    private List<HomeworkObserver> homeworkObservers;

    public HomeworkQueue() {
        this.homeworkTasks = new ArrayList<>();
        this.homeworkObservers = new ArrayList<>();
    }


    @Override
    public void registerObserver(HomeworkObserver observer) {
        this.homeworkObservers.add(observer);
    }

    public void notifyObservers() {
        for(HomeworkObserver observer:homeworkObservers) {
            observer.update(this);
        }
    }

    public void removeObserver(HomeworkObserver observer) {
        this.homeworkObservers.remove(observer);
    }

    public List<HomeworkTask> getHomeworkTasks() {
        return homeworkTasks;
    }
}
