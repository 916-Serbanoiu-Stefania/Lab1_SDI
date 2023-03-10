package com.example.demo.API;

import com.example.demo.Model.Worker;
import com.example.demo.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/worker")
@RestController
public class WorkerController {
    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }


    // this is a request
    @PostMapping
    public void addNewWorker(@RequestBody Worker worker)
    {
        int result = workerService.addService(worker);
    }

    @GetMapping
    public List<Worker> getAllWorkers()
    {
        return workerService.getWorkersService();
    }

    @GetMapping(path = "{id}")
    public Optional<Worker> getWorker(@PathVariable("id") UUID id)
    {
        return workerService.getService(id);
    }

    @DeleteMapping(path = "{id}")
    public int deleteWorker(@PathVariable("id") UUID id)
    {
        int result = workerService.deleteService(id);
        return result;
    }

    @PutMapping(path = "{id}")
    public void updateWorkerInfo(@PathVariable("id") UUID id, @RequestBody Worker worker)
    {
        workerService.updateService(id, worker);
    }

    @GetMapping(path = "/salary/{salary}")
    public List<Worker> filterBySalary(@PathVariable("salary") int salary)
    {
        return workerService.filterService(salary);
    }
}
