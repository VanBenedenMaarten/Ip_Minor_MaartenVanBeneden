package pe.taskmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.taskmanager.service.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
