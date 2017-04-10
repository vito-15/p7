package com.p7.mvc.service;

import com.p7.mvc.model.Task;
import java.util.List;

public interface TaskService {
    public void addTask(Task t);
    public void updateTask(Task t);
    public List<Task> listTasks();
    public List<Task> listTasksDone();
    public List<Task> listTasksNotDone(int firstResult,int total);
    public Task getTaskById(int id);
    public void removeTask(int id);
}
