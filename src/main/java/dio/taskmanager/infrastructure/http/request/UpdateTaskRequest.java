package dio.taskmanager.infrastructure.http.request;

import dio.taskmanager.application.input.UpdateTaskInput;
import dio.taskmanager.domain.enums.TaskStatus;

import java.util.Optional;

public record UpdateTaskRequest(
        Optional<String> title,
        Optional<String> description,
        Optional<String> status
) {
    public UpdateTaskInput toIpunt() {
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}
