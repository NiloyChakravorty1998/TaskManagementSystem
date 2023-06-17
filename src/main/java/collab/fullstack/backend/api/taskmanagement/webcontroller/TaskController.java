package collab.fullstack.backend.api.taskmanagement.webcontroller;

import collab.fullstack.backend.api.taskmanagement.service.task.TaskServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskServiceImpl service;

    public TaskController(TaskServiceImpl service) {
        this.service = service;
    }


}
