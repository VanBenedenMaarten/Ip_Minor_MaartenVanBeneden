package pe.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.taskmanager.dto.TaskDTO;
import pe.taskmanager.service.TaskService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class TaskmanagerController {

    @Autowired
    TaskService taskService;

    @GetMapping("/")
    public String getindex(){
        return "index";
    }

    @GetMapping("tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "tasks";
    }

    @GetMapping("tasks/{id}")
    public String getTask(Model model, @PathVariable("id") Integer id) {
        TaskDTO task = taskService.getTask(id);
        model.addAttribute("task", task);
        return "task";
    }

    @GetMapping("tasks/edit/{id}")
    public String getEditTask(Model model, @PathVariable("id") Integer id) {
        TaskDTO task = taskService.getTask(id);
        model.addAttribute("task", task);
        return "edit";
    }

    @PostMapping("tasks/change/{taskId}")
    public String getChangeTask(Model model, @ModelAttribute @Valid TaskDTO newTask, @PathVariable("taskId") Integer taskId) {
        taskService.editTask(taskId, newTask);
        model.addAttribute("tasks", taskService.getTasks());
        return "redirect:/tasks/" + taskId;
    }

    @GetMapping("tasks/new")
    public String getNew() {
        return "new";
    }

    @PostMapping("tasks/new")
    public String createNew(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        taskService.addTask(task);
        return "redirect:/tasks";
    }
}
