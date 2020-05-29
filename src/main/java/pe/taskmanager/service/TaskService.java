package pe.taskmanager.service;

import org.springframework.stereotype.Service;
import pe.taskmanager.dto.TaskDTO;

import java.util.List;

@Service
public interface TaskService {
    List<TaskDTO> getTasks();
    void addTask(TaskDTO taskDTO);
    TaskDTO getTask(int id);
    void editTask(int id, TaskDTO newTask);

}
