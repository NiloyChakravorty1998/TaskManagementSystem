package collab.fullstack.backend.api.taskmanagement.service.task;

import collab.fullstack.backend.api.taskmanagement.model.Task;
import collab.fullstack.backend.api.taskmanagement.model.User;
import collab.fullstack.backend.api.taskmanagement.repo.task.TaskDAO;
import collab.fullstack.backend.api.taskmanagement.repo.task.TaskRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    private TaskRepo repo;
    private TaskDAO taskDAO;

    public TaskServiceImpl(TaskRepo repo, TaskDAO taskDAO) {
        this.repo = repo;
        this.taskDAO = taskDAO;
    }

    @Override
    public Task createTask(Task task) {
        repo.save(task);
        return task;
    }

    @Override
    public Task findTask(Long id) {
        return repo.getReferenceById(id);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Task taskToUpdate = repo.getReferenceById(id);
        taskToUpdate.setTaskId(id);
        taskToUpdate.setTaskName(task.getTaskName());
        taskToUpdate.setTaskStartTime(task.getTaskStartTime());
        taskToUpdate.setTaskEndTime(task.getTaskEndTime());
        taskToUpdate.setTaskDescription(task.getTaskDescription());
        taskToUpdate.setTaskPriority(task.getTaskPriority());
        taskToUpdate.setStartDate(task.getStartDate());
        taskToUpdate.setEndDate(task.getEndDate());
        taskToUpdate.setCompletionStatus(task.getCompletionStatus());
        taskToUpdate.setUser(task.getUser());

        repo.save(taskToUpdate);
        return taskToUpdate;
    }

    @Override
    public String deleteTask(Long id) {
        Task taskToDelete = repo.getReferenceById(id);
        String userName = taskToDelete.getUser().getFirstName();
        repo.delete(repo.getReferenceById(id));
        return "Deleted task with ID :" +id +"for user: " +userName;
    }

    @Override
    public String completeTask(Long id) {
        Task taskCompleted = repo.getReferenceById(id);
        taskDAO.updateTaskCompletionStatus(id,taskCompleted.getUser().getUserId());
        return "Completed";
    }

    @Override
    public List<Task> taskListByAsc(User user) {
        return repo.findByUserUserIdAndCompletionStatusOrderByTaskPriorityAsc(user.getUserId(),"N");
    }

    @Override
    public List<Task> taskListByDesc(User user) {
        return repo.findByUserUserIdAndCompletionStatusOrderByTaskPriorityDesc(user.getUserId(),"N");
    }

    @Override
    public Optional<List<Task>> taskOnADate(LocalDate date) {
        return repo.findByStartDate(date);
    }
}
