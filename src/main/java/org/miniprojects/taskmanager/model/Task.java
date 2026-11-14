package org.miniprojects.taskmanager.model;

public class Task{
    private final int taskId;
    private final String title;
    private final String descriptionString;
    private final TaskPriority priority;
    private TaskStatus status;
    
    // Static Variables
    private static int lastTaskID = 0;


    public Task(String title, String descriptionString, TaskPriority priority){
        this.taskId = getNextTaskID();
        this.title = title;
        this.descriptionString = descriptionString;
        this.priority = priority;
        this.status = TaskStatus.TODO;
    }

    public int getTaskId(){
        return this.taskId;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescriptionString(){
        return this.descriptionString;
    }

    public TaskPriority getPriority(){
        return this.priority;
    }

    public TaskStatus getStatus(){
        return this.status;
    }

    public void start(){
        this.status = TaskStatus.IN_PROGRESS;
    }

    public void complete(){
        this.status = TaskStatus.COMPLETED;
    }

    public static int getNextTaskID(){
        return ++lastTaskID;
    }
}