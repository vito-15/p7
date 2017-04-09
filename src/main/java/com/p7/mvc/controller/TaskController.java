package com.p7.mvc.controller;

import com.p7.mvc.model.Task;
import com.p7.mvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {
    private TaskService taskService;

    @Autowired(required=true)
    @Qualifier(value="taskService")
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String listTasks(Model model) {
        //Для создания новой задачи
        //model.addAttribute("task", new Task());
        model.addAttribute("listTasks", this.taskService.listTasks());
        return "taskList";
    }

}
