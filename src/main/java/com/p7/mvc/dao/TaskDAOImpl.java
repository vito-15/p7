package com.p7.mvc.dao;

import com.p7.mvc.model.Task;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    //Example
    //Query query = session.createQuery("from Student s where s.name like 'k%'");

    @Override
    public List<Task> listTasks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Task> taskList=session.createQuery("from Task").list();
        for(Task t : taskList){
            logger.info("Task List::"+t);
        }
        return taskList;
    }
    @Override
    public List<Task> listTasksDone(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Task> taskList=session.createQuery("from Task t where t.isDone").list();
        for(Task t : taskList){
            logger.info("Task List::"+t);
        }
        return taskList;
    }

    @Override
    public List<Task> listTasksNotDone(int firstResult,int total){
        Session session = this.sessionFactory.getCurrentSession();
        String sql =String.format("select * from Task t where not t.isDone limit %d,%d",firstResult,total);
        Query query=session.createSQLQuery(sql);

        Query q2=session.createQuery("From Task");


        List<Task> taskList=new ArrayList<>();
        List resultList=query.list();
        for(Object o : resultList){
            Task t=(Task)o;
            taskList.add(t);
        }


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
