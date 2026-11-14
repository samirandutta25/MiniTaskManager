package org.miniprojects.taskmanager.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.miniprojects.taskmanager.model.Task;
import org.miniprojects.taskmanager.model.TaskPriority;


public class TaskManager {
    private final Map<Integer, Task> tasks = new HashMap<>();

    public int addTask(String title, String descriptionString, TaskPriority priority){
        Task task = new Task(title, descriptionString, priority);
        int taskId = task.getTaskId();
        // Boxing will take care of int -> Integer
        tasks.put(taskId, task);
        return taskId;
    }

    public Task getTask(int taskID){
        return tasks.get(taskID);
    }

    public List<Task> getTasks(){
        return List.copyOf(tasks.values());
    }

    public void startTask(int taskID){
        Task task = getTask(taskID);
        if (task != null){
            task.start();
        }
    }

    public void completeTask(int taskID){
        Task task = getTask(taskID);
        if (task != null){
            task.complete();
        }
    }

    public Task removeTask(int taskID){
        Task task = getTask(taskID);
        tasks.remove(taskID);
        return task;
    }

}