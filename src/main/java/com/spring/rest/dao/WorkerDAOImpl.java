package com.spring.rest.dao;


import com.spring.rest.entity.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerDAOImpl implements WorkerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override

    public List<Worker> getAllWorkers() {

        Session session = sessionFactory.getCurrentSession();
        List<Worker> workers = session.createQuery("from Worker", Worker.class).getResultList();
        return workers;
    }

    @Override
    public void saveNewWorker(Worker worker) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(worker);
    }

    @Override
    public Worker getWorker(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Worker.class, id);
    }

    @Override
    public void deleteWorker(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query<Worker> query = session.createQuery("delete from Worker where id = :workerId");
        query.setParameter("workerId", id);
        query.executeUpdate();
    }
}
