package collab.fullstack.backend.api.taskmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;

    private String taskName;
    private String taskDescription;
    private LocalDateTime taskStartTime;
    private LocalDate startDate;
    private LocalDateTime taskEndTime;
    private LocalDate endDate;

    private String completionStatus = "N";
    private int taskPriority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
