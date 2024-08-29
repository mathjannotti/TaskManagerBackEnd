package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        task.setId(counter.getAndIncrement());
        tasks.add(task);
    }

    public Optional<Task> getTaskById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    public void updateTask(Task updatedTask) {
        getTaskById(updatedTask.getId()).ifPresent(task -> {
            task.setName(updatedTask.getName());
            task.setResponsible(updatedTask.getResponsible());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
        });
    }

    public void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
