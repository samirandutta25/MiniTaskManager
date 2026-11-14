package org.miniprojects.taskmanager.model;

public enum TaskPriority{
    LOW(100),
    MEDIUM(10),
    HIGH(5);

    private final int priorityRank;

    TaskPriority(int priorityRank){
        this.priorityRank = priorityRank;
    }

    public int getPriorityRank(){
        return this.priorityRank;
    }
}