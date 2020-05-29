package pe.taskmanager.db;

import pe.taskmanager.service.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDb {
    private List<Task> tasks;

    public TaskDb() {
        tasks = new ArrayList<>();

    }
}
