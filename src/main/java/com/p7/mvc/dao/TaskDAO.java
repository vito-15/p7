package com.p7.mvc.dao;

import com.p7.mvc.model.Task;

import java.util.List;

/**
 * Created by sadmin on 09.04.17.
 */
public interface TaskDAO {
    public void addTask(Task t);
    public void updateTask(Task t);
    public List<Task> listTasks(int firstResult,int total);
    public List<Task> listTasksDone(int firstResult,int total);
    public List<Task> listTasksNotDone(int firstResult,int total);
    public Task getTaskById(int id);
    public void removeTask(int id);
}
