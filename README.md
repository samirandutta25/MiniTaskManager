# Mini Task Manager

A small command-line task manager built as a practical Java learning project. It is intentionally kept simple and stores tasks in memory for the duration of the application run.

## Project intention

This project is for learning Java by building a working application incrementally. It focuses on classes and objects, enums, collections, encapsulation, and separating task management from command-line input and output.

## Features

- Add a task with a title, description, and priority.
- List tasks and view an individual task's details.
- Start or complete a task.
- Remove a task.
- Keep task data in memory while the application is running.

Tasks are sorted when listed: incomplete tasks come before completed tasks, higher-priority tasks come first, and ties are ordered by task ID.

## Requirements and versions

- Java 21 language/API target, configured with Maven's `maven.compiler.release` property.
- Maven 3.10.0 was used to build this project.
- A JDK 21 or later is required to compile with the configured Java 21 release target.

The Maven configuration in `pom.xml` was generated with AI assistance and then used for this project.

## Build and run

Run these commands from the project root:

```shell
# Compile and package the executable JAR
mvn package

# Run the application
java -jar target/MiniTaskManager-1.0-SNAPSHOT.jar
```

To clean previous build output and rebuild:

```shell
mvn clean package
```

The build creates compiled classes under `target/classes` and the executable JAR under `target/`. Running the JAR starts the interactive menu; the build itself does not prompt for menu input.
