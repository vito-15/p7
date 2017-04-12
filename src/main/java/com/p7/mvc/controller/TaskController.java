package com.p7.mvc.controller;

import com.p7.mvc.model.PageViewData;
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

import java.util.HashMap;
import java.util.Map;

@Controller
public class TaskController {
    private TaskService taskService;
    //private static final Logger logger = Logger.getLogger("TaskController.class");

    @Autowired(required=true)
    @Qualifier(value="taskService")
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public String listTasks(Model model,PageViewData data) {
        Map< String, String > taskFilter = new HashMap<String, String>();
        taskFilter.put("all","All");
        taskFilter.put("done","Complited");
        taskFilter.put("nonDone","Not complited");

        model.addAttribute("taskFilterJSP",taskFilter);

        model.addAttribute("pageDataJSP",data);
        if(data.getShowTasks().equals("all")){
            model.addAttribute("listTasksJSP", this.taskService.listTasks(data.getFirstResult(),data.getTotal()));
        }
        if(data.getShowTasks().equals("done")){
            model.addAttribute("listTasksJSP", this.taskService.listTasksDone(data.getFirstResult(),data.getTotal()));
        }

        if(data.getShowTasks().equals("nonDone")){
            model.addAttribute("listTasksJSP", this.taskService.listTasksNotDone(data.getFirstResult(),data.getTotal()));
        }
        return "taskList";
    }

    //Default parameters
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String listTasksDefault(Model model) {
        PageViewData data=new PageViewData();
        data.setFirstResult(0);
        data.setTotal(10);
        data.setShowTasks("nonDone");
        return listTasks(model,data);
    }

    @RequestMapping(value = "/tasks",params="show", method = RequestMethod.POST)
    public String listTasksShow(@ModelAttribute PageViewData data, Model model) {
        if(data.getFirstResult()<0 || data.getTotal()<0)return listTasksDefault(model);
        //calculate new firstResult
        //data.setFirstResult(data.getFirstResult()+data.getTotal());

        //data.setFirstResult(data.getFirstResult()-data.getTotal());
        //if(data.getFirstResult()<0)data.setFirstResult(0);
        return listTasks(model,data);
    }

    @RequestMapping(value = "/tasks",params="next", method = RequestMethod.POST)
    public String listTasksNext(@ModelAttribute PageViewData data, Model model) {
        if(data.getFirstResult()<0 || data.getTotal()<0)return listTasksDefault(model);
        //calculate new firstResult
        data.setFirstResult(data.getFirstResult()+data.getTotal());

        //data.setFirstResult(data.getFirstResult()-data.getTotal());
        //if(data.getFirstResult()<0)data.setFirstResult(0);
        return listTasks(model,data);
    }

    @RequestMapping(value = "/tasks",params="prev", method = RequestMethod.POST)
    public String listTasksPrev(@ModelAttribute PageViewData data, Model model) {
        if(data.getFirstResult()<0 || data.getTotal()<0)return listTasksDefault(model);
        //calculate new firstResult
        data.setFirstResult(data.getFirstResult()-data.getTotal());
        if(data.getFirstResult()<0)data.setFirstResult(0);
        return listTasks(model,data);
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

    @RequestMapping(value = "/tasks/remove/{id}")
    public String removeTask(@PathVariable("id") int id){
        this.taskService.removeTask(id);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks/complite/{id}")
    public String compliteTask(@PathVariable("id") int id){
        Task t = this.taskService.getTaskById(id);
        t.setDone(true);
        taskService.updateTask(t);
        return "redirect:/tasks";
    }

    @RequestMapping(value = "/tasks/noncomplite/{id}")
    public String nonCompliteTask(@PathVariable("id") int id){
        Task t = this.taskService.getTaskById(id);
        t.setDone(false);
        taskService.updateTask(t);
        return "redirect:/tasks";
    }
}
