package com.spring.rest.controller;

import com.spring.rest.entity.Worker;
import com.spring.rest.exception_handling.NoSuchWorkerException;
import com.spring.rest.service.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/workers")
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("/worker/{id}")
    public Worker getWorker(@PathVariable int id) {

        Worker worker = workerService.getWorker(id);

        if (worker == null) {
            throw new NoSuchWorkerException("There is no worker with id = " + id + " in database");
        }

        return worker;
    }

    @PostMapping("/worker")
    public Worker addWorker(@RequestBody Worker worker){
        workerService.saveNewWorker(worker);

        return worker;
    }

    @PutMapping("/worker")
    public Worker updateWorker(@RequestBody Worker worker){
        workerService.saveNewWorker(worker);

        return worker;
    }

    @DeleteMapping("/worker/{id}")
    public String deleteWorker(@PathVariable int id){
        Worker worker = workerService.getWorker(id);
        if (worker == null) {
            throw new NoSuchWorkerException("There is no worker with id = " + id + " in database");
        }

        workerService.deleteWorker(id);

        return "Worker with id = " + id + " deleted";
    }

}
