package org.miniprojects.taskmanager.comparators;

import java.util.Comparator;

import org.miniprojects.taskmanager.model.Task;
import org.miniprojects.taskmanager.model.TaskStatus;

public class TaskComparator implements Comparator<Task> {

    private int compareCreationOrder(Task t1, Task t2){
        return t1.getTaskId() - t2.getTaskId();
    }

    private int comparePriorityOrder(Task t1, Task t2){
        return t1.getPriority().getPriorityRank() - t2.getPriority().getPriorityRank();
    }

    private int compareCompletionStatus(Task t1, Task t2){
        if( t1.getStatus() == TaskStatus.COMPLETED && t2.getStatus() == TaskStatus.COMPLETED )
            return 0;
        if( t1.getStatus() == TaskStatus.COMPLETED )
            return 1;
        if( t2.getStatus() == TaskStatus.COMPLETED )
            return -1;
        return 0;
    }

    @Override
    public int compare(Task t1, Task t2){
        int completionStatus = compareCompletionStatus(t1, t2);
        if (completionStatus != 0)
            return completionStatus;
        int priorityOrder = comparePriorityOrder(t1, t2);
        if (priorityOrder != 0)
            return priorityOrder;
        return compareCreationOrder(t1, t2);
    }
}