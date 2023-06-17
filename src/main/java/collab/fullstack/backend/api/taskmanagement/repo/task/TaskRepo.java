package collab.fullstack.backend.api.taskmanagement.repo.task;

import collab.fullstack.backend.api.taskmanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<Task,Long> {
    List<Task> findByUserUserIdAndCompletionStatusOrderByTaskPriorityAsc(Long userId, String completionStatus);
    List<Task> findByUserUserIdAndCompletionStatusOrderByTaskPriorityDesc(Long userId, String completionStatus);
    Optional<List<Task>> findByStartDate(LocalDate date);

}
