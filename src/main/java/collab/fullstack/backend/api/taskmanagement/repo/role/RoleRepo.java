package collab.fullstack.backend.api.taskmanagement.repo.role;

import collab.fullstack.backend.api.taskmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
}
