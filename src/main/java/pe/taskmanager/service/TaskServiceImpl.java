package pe.taskmanager.service;

import org.springframework.stereotype.Service;
import pe.taskmanager.dto.TaskDTO;
import pe.taskmanager.repo.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("Taak 1");
        taskDTO.setDescription("Dit is een test");
        taskDTO.setDateDue("2020-10-30");
        addTask(taskDTO);
    }

    @Override
    public List<TaskDTO> getTasks() {
        return repository.findAll().stream().map(h -> {
            TaskDTO dto = new TaskDTO();
            dto.setId(h.getId());
            dto.setDateDue(h.getDateDue());
            dto.setDescription(h.getDescription());
            dto.setTitle(h.getTitle());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDateDue(taskDTO.getDateDue());
        repository.save(task);
    }

    @Override
    public TaskDTO getTask(int id) {
        for (TaskDTO task : getTasks()) {
            if (task.getId().equals((long) id)) {
                return task;
            }
        }
        return null;
    }

    @Override
    public void editTask(int id, TaskDTO newTask) {
        newTask.setId((long) id);
        Task task = new Task();
        task.setId((long) id);
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        task.setDateDue(newTask.getDateDue());
        repository.save(task);
    }
}
