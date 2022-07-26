package com.spring.rest.dao;

import com.spring.rest.entity.Worker;

import java.util.List;

public interface WorkerDAO {
    public List<Worker> getAllWorkers();

    public void saveNewWorker(Worker worker);

    public Worker getWorker(int id);

    public void deleteWorker(int id);
}
