package dio.taskmanager.domain.exceptions;

import dio.taskmanager.domain.TaskId;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(TaskId id) {

        super("Task with id " + id  + " Not Found!");
    }
}
