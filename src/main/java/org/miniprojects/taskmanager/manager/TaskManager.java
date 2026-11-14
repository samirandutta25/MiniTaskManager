package org.miniprojects.taskmanager.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.miniprojects.taskmanager.comparators.TaskComparator;
import org.miniprojects.taskmanager.model.Task;
import org.miniprojects.taskmanager.model.TaskPriority;


public class TaskManager implements Iterable<Task>{
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

    @Override
    public Iterator<Task> iterator() {
        List<Task> taskList = new ArrayList<>(tasks.values());
        taskList.sort(new TaskComparator());

        return new Iterator<Task>(){
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < taskList.size();
            }
            
            @Override
            public Task next(){
                if (!hasNext())
                    throw new NoSuchElementException();
                return taskList.get(index++);
            }
        };
    }

}