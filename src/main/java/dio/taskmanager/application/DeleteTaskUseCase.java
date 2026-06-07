package dio.taskmanager.application;

import dio.taskmanager.domain.TaskId;
import dio.taskmanager.domain.TaskRepository;
import dio.taskmanager.domain.exceptions.TaskNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }
    public void execute(TaskId id){
        if (repository.findById(id).isEmpty()){
            throw new TaskNotFoundException(id);
        }
        repository.delete(id);
    }

}
