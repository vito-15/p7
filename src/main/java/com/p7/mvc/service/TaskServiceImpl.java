package com.p7.mvc.service;


import com.p7.mvc.dao.TaskDAO;
import com.p7.mvc.model.Task;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskDAO taskDAO;

    public void setTaskDAO(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    @Transactional
    public void addTask(Task t) {
        this.taskDAO.addTask(t);
    }

    @Override
    @Transactional
    public void updateTask(Task t) {
        this.taskDAO.updateTask(t);
    }

    @Override
    @Transactional
    public List<Task> listTasks(int firstResult,int total) {
        return this.taskDAO.listTasks(firstResult,total);
    }

    @Override
    @Transactional
    public List<Task> listTasksDone(int firstResult,int total){
        return this.taskDAO.listTasksDone(firstResult,total);
    }

    @Override
    @Transactional
    public List<Task> listTasksNotDone(int firstResult,int total){
        return this.taskDAO.listTasksNotDone(firstResult,total);
    }

    @Override
    @Transactional
    public Task getTaskById(int id) {
        return this.taskDAO.getTaskById(id);
    }

    @Override
    @Transactional
    public void removeTask(int id) {
        this.taskDAO.removeTask(id);
    }
}
