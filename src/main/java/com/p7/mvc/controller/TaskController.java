package com.p7.mvc.controller;

import com.p7.mvc.model.Task;
import com.p7.mvc.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {
    private TaskService taskService;
    //private static final Logger logger = Logger.getLogger("TaskController.class");

    @Autowired(required=true)
    @Qualifier(value="taskService")
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String listTasks(Model model) {
        model.addAttribute("listTasks", this.taskService.listTasks());
        return "taskList";
    }

    @RequestMapping(value = "/tasks/edit/{id}",method = RequestMethod.GET)
    public String editTaskForm(@PathVariable("id") int id, Model model){
        model.addAttribute("taskJSP", this.taskService.getTaskById(id));
        return "editTask";
    }

    @RequestMapping(value = "/tasks/edit",method = RequestMethod.POST)
    public String editTaskSubmit(@ModelAttribute Task task){
        this.taskService.updateTask(task);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks/add",method = RequestMethod.GET)
    public String addTaskForm(Model model){
        model.addAttribute("taskJSP",new Task());
        return "addTask";
    }

    @RequestMapping(value = "/tasks/add",method = RequestMethod.POST)
    public String addTaskSubmit(@ModelAttribute Task task){
        this.taskService.addTask(task);
        return "redirect:/tasks";
    }


}
