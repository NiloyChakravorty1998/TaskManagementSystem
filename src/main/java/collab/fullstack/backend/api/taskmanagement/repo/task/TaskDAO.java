package collab.fullstack.backend.api.taskmanagement.repo.task;

import collab.fullstack.backend.api.taskmanagement.config.DbConfig;
import collab.fullstack.backend.api.taskmanagement.model.Task;
import collab.fullstack.backend.api.taskmanagement.model.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskDAO {

    private DbConfig dbConfig;

    public TaskDAO(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public void updateTaskCompletionStatus(Long taskId, Long userId)
    {
        try (Connection connection = dbConfig.getConnection();

        PreparedStatement statement =
                connection.prepareStatement("UPDATE task SET completion_status = 'Y' " +
                        "WHERE task_id = ? AND user_id = ?")) {

        statement.setLong(1, taskId);
            statement.setLong(1, userId);
        int rowsAffected = statement.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
        e.printStackTrace();
        }
    }
}


