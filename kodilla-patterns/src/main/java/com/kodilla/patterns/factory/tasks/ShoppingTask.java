package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {
    private boolean isTaskExecuted;
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
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
