package collab.fullstack.backend.api.taskmanagement.webcontroller;

import collab.fullstack.backend.api.taskmanagement.model.Task;
import collab.fullstack.backend.api.taskmanagement.model.User;
import collab.fullstack.backend.api.taskmanagement.service.task.TaskServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskServiceImpl service;

    public TaskController(TaskServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("/")
    public ResponseEntity<Task> newTask(@RequestBody Task task)
    {
        service.createTask(task);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/:{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id)
    {
        Task getTask = service.findTask(id);
        return ResponseEntity.ok(getTask);
    }

    @PutMapping
    @RequestMapping("/:{id}")
    public ResponseEntity<Task> newTask(@PathVariable Long id, @RequestBody Task task)
    {
        service.updateTask(id,task);
        return ResponseEntity.ok(service.findTask(id));
    }

    @DeleteMapping
    @RequestMapping("/:{id}")
    public String deleteTask(@PathVariable Long id)
    {
        return service.deleteTask(id);
    }

    @PostMapping
    @RequestMapping("/completeTask/{id}")
    public ResponseEntity<Task> completeTask(@PathVariable Long id)
    {
        service.completeTask(id);
        return ResponseEntity.ok(service.findTask(id));
    }

    @GetMapping("/sort={asc}")
    public ResponseEntity<List<Task>> taskInAsc(@RequestBody User user)
    {
        List<Task> tasks = service.taskListByAsc(user);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/sort={desc}")
    public ResponseEntity<List<Task>> taskInDesc(@RequestBody User user)
    {
        List<Task> tasks = service.taskListByDesc(user);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/sort={startDate}")
    public ResponseEntity<Optional<List<Task>>> taskForStartDate(@PathVariable LocalDate startDate)
    {
        return ResponseEntity.ok(service.taskOnADate(startDate));
    }

}
