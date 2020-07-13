package com.kodilla.patterns.factory.tasks;

public class DrivingTask implements Task {
    private boolean isTaskExecuted;
    private final String taskName;
    private final String where;
    private final String using;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() throws TaskAlreadyExecutedException {
        if (isTaskExecuted) {
            throw new TaskAlreadyExecutedException();
        } else {
            System.out.println("Task is being executed...");
            isTaskExecuted = true;
        }
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return isTaskExecuted;
    }
}
