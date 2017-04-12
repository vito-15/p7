package com.p7.mvc.dao;

import com.p7.mvc.model.Task;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    private static final Logger logger = Logger.getLogger("TaskDAOImpl.class");
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addTask(Task t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(t);
        logger.info("Task saved successfully, Task Details="+t);
    }

    @Override
    public void updateTask(Task t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(t);
        logger.info("Task updated successfully, Task Details="+t);
    }

    @Override
    public List<Task> listTasks(int firstResult,int total) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Task");
        //if firstResult==0 && total==0 1 return all tasks
        if(firstResult!=0 || total!=0){
            query.setFirstResult(firstResult);
            query.setMaxResults(total);
        }
        List<Task> taskList=query.list();
        for(Task t : taskList){
            logger.info("Task List::"+t);
        }
        return taskList;
    }
    @Override
    public List<Task> listTasksDone(int firstResult,int total){
        Session session = this.sessionFactory.getCurrentSession();
        Query query=session.createQuery("FROM Task WHERE isDone = :isdone").setBoolean("isdone",Boolean.TRUE);
        //if firstResult==0 && total==0 1 return all tasks
        if(firstResult!=0 || total!=0){
            query.setFirstResult(firstResult);
            query.setMaxResults(total);
        }
        List<Task> taskList=query.list();
        for(Task t : taskList){
            logger.info("Task List::"+t);
        }
        return taskList;
    }

    @Override
    public List<Task> listTasksNotDone(int firstResult,int total){
        Session session = this.sessionFactory.getCurrentSession();
        Query query=session.createQuery("FROM Task WHERE isDone = :isdone").setBoolean("isdone",Boolean.FALSE);
        //if firstResult==0 && total==0 1 return all tasks
        if(firstResult!=0 || total!=0){
            query.setFirstResult(firstResult);
            query.setMaxResults(total);
        }
        List<Task> taskList=query.list();

        for(Task t : taskList){
            logger.info("Task List::"+t);
        }
        return taskList;
    }

    @Override
    public Task getTaskById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Task t = (Task) session.load(Task.class, new Integer(id));
        logger.info("Task loaded successfully, Task Details="+t);
        return t;
    }

    @Override
    public void removeTask(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Task t = (Task) session.load(Task.class, new Integer(id));
        if(null != t){
            session.delete(t);
        }
        logger.info("Task deleted successfully, Task Details="+t);
    }
}