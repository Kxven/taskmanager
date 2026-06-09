package dio.taskmanager.infrastructure.http;

import dio.taskmanager.application.*;
import dio.taskmanager.application.input.CreateTaskInput;
import dio.taskmanager.domain.TaskId;
import dio.taskmanager.infrastructure.http.request.CreateTaskRequest;
import dio.taskmanager.infrastructure.http.request.UpdateTaskRequest;
import dio.taskmanager.infrastructure.http.response.TaskResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private final GetTasksUseCase getTasksUseCase;
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskRequest;

    public TaskController(CreateTaskUseCase createTaskUseCase, GetTasksUseCase getTasksUseCase, GetTaskByIdUseCase getTaskByIdUseCase, DeleteTaskUseCase deleteTaskUseCase, UpdateTaskUseCase updateTaskRequest) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTasksUseCase = getTasksUseCase;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.updateTaskRequest = updateTaskRequest;
    }

    @PostMapping
    TaskResponse create(@RequestBody @Valid CreateTaskRequest request){
        var input = request.toInput();
        var output = createTaskUseCase.execute(input);
        return TaskResponse.from(output);
    }
    @GetMapping
    List<TaskResponse> list(){
        return getTasksUseCase.execute().stream().map(TaskResponse::from).toList();
    }
    @GetMapping("/{id}")
    TaskResponse read(@PathVariable UUID id) {
        var outpout = getTaskByIdUseCase.execute(new TaskId(id));
        return TaskResponse.from(outpout);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id){
        deleteTaskUseCase.execute(new TaskId(id));
    }

    @PatchMapping("/{id}")
    TaskResponse update(@PathVariable UUID id, @RequestBody UpdateTaskRequest request){
        var input = request.toIpunt();
        var output = updateTaskRequest.execute(new TaskId(id), input);
        return TaskResponse.from(output);
    }
}
