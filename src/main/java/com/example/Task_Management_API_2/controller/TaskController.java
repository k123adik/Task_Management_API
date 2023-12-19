package com.example.Task_Management_API_2.controller;

import com.example.Task_Management_API_2.model.Task;
import com.example.Task_Management_API_2.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        task.setId(taskId);
        return taskService.saveTask(task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
