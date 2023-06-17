package collab.fullstack.backend.api.taskmanagement.repo.user;

import collab.fullstack.backend.api.taskmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
