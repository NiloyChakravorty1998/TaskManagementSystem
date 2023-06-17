package collab.fullstack.backend.api.taskmanagement.service.task;

import collab.fullstack.backend.api.taskmanagement.model.Task;
import collab.fullstack.backend.api.taskmanagement.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    Task findTask(Long id);
    Task updateTask(Long id, Task task);
    String deleteTask(Long id);
    String completeTask(Long id);
    List<Task> taskListByAsc(User user);
    List<Task> taskListByDesc(User user);
    Optional<List<Task>> taskOnADate(LocalDate date);
}
