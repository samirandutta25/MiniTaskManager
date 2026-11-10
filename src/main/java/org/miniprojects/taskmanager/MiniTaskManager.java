/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.miniprojects.taskmanager;

import java.util.List;
import java.util.Scanner;

public class MiniTaskManager {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                System.out.println("\n1. Add task");
                System.out.println("2. Show task list");
                System.out.println("3. Show task details");
                System.out.println("4. Start task");
                System.out.println("5. Complete task");
                System.out.println("6. Remove task");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");

                String input = scanner.nextLine().trim();
                int option;

                try {
                    option = Integer.parseInt(input);
                } catch (NumberFormatException exception) {
                    System.out.println("Please enter a number from the menu.");
                    continue;
                }

                switch (option) {
                    case 1 -> addTask(scanner, taskManager);
                    case 2 -> showTasks(taskManager);
                    case 3 -> showTaskDetails(scanner, taskManager);
                    case 4 -> startTask(scanner, taskManager);
                    case 5 -> completeTask(scanner, taskManager);
                    case 6 -> removeTask(scanner, taskManager);
                    case 0 -> running = false;
                    default -> System.out.println("Unknown option. Please choose one of the listed options.");
                }
            }
        }
    }

    private static void showTasks(TaskManager taskManager) {
        List<Task> tasks = taskManager.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks yet.");
            return;
        }

        for (Task task : tasks) {
            printTaskHeader(task);
        }
    }

    private static void addTask(Scanner scanner, TaskManager taskManager) {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Priority (LOW, MEDIUM, HIGH): ");
        String priorityInput = scanner.nextLine().trim().toUpperCase();

        try {
            TaskPriority priority = TaskPriority.valueOf(priorityInput);
            int taskId = taskManager.addTask(title, description, priority);
            System.out.println("Task added with ID " + taskId + ".");
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid priority. Task was not added.");
        }
    }

    private static void showTaskDetails(Scanner scanner, TaskManager taskManager) {
        Integer taskId = readTaskId(scanner);
        if (taskId == null) {
            return;
        }

        Task task = taskManager.getTask(taskId);
        if (task == null) {
            System.out.println("No task found with ID " + taskId + ".");
            return;
        }

        printTaskHeader(task);
        System.out.println("------------------------------");
        System.out.println("Priority: " + task.getPriority());
        System.out.println("Description: " + task.getDescriptionString());
    }

    private static void printTaskHeader(Task task) {
        System.out.printf("[%d] %s (%s)%n",
                task.getTaskId(),
                task.getTitle(),
                task.getStatus());
    }

    private static void startTask(Scanner scanner, TaskManager taskManager) {
        Integer taskId = readTaskId(scanner);
        if (taskId == null) {
            return;
        }

        if (taskManager.getTask(taskId) == null) {
            System.out.println("No task found with ID " + taskId + ".");
            return;
        }

        taskManager.startTask(taskId);
        System.out.println("Task " + taskId + " started.");
    }

    private static void completeTask(Scanner scanner, TaskManager taskManager) {
        Integer taskId = readTaskId(scanner);
        if (taskId == null) {
            return;
        }

        if (taskManager.getTask(taskId) == null) {
            System.out.println("No task found with ID " + taskId + ".");
            return;
        }

        taskManager.completeTask(taskId);
        System.out.println("Task " + taskId + " completed.");
    }

    private static void removeTask(Scanner scanner, TaskManager taskManager) {
        Integer taskId = readTaskId(scanner);
        if (taskId == null) {
            return;
        }

        Task removedTask = taskManager.removeTask(taskId);
        if (removedTask == null) {
            System.out.println("No task found with ID " + taskId + ".");
        } else {
            System.out.println("Task " + taskId + " removed.");
        }
    }

    private static Integer readTaskId(Scanner scanner) {
        System.out.print("Task ID: ");
        String input = scanner.nextLine().trim();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            System.out.println("Please enter a valid numeric task ID.");
            return null;
        }
    }

}
