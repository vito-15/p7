package com.p7.mvc.service;

import com.p7.mvc.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.annotation.Resource;
import java.util.List;


@Service("personService")
@Transactional
public class PersonService {
    protected static Logger logger = Logger.getLogger("service");

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    /**
     * Retrieves all persons
     *
     * @return a list of persons
     */
    public List<Person> getAll() {
        logger.debug("Retrieving all persons");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Create a Hibernate query (HQL)
        Query query = session.createQuery("FROM  Person");

        // Retrieve all
        return  query.list();
    }

    /**
     * Retrieves a single person
     */
    public Person get( Integer id ) {
        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Person person = (Person) session.get(Person.class, id);

        return person;
    }

    /**
     * Adds a new person
     */
    public void add(Person person) {
        logger.debug("Adding new person");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Save
        session.save(person);
    }

    /**
     * Deletes an existing person
     * @param id the id of the existing person
     */
    public void delete(Integer id) {
        logger.debug("Deleting existing person");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person first
        Person person = (Person) session.get(Person.class, id);

        // Delete
        session.delete(person);
    }

    /**
     * Edits an existing person
     */
    public void edit(Person person) {
        logger.debug("Editing existing person");

        // Retrieve session from Hibernate
        Session session = sessionFactory.getCurrentSession();

        // Retrieve existing person via id
        Person existingPerson = (Person) session.get(Person.class, person.getId());

        // Assign updated values to this person
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(existingPerson.getLastName());
        existingPerson.setMoney(existingPerson.getMoney());

        // Save updates
        session.save(existingPerson);
    }


}
