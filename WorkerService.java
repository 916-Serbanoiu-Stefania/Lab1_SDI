package com.example.demo.Service;

import com.example.demo.In_MemoryRepo.WorkerInMemoryRepoInterface;
import com.example.demo.Model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkerService {
    private final WorkerInMemoryRepoInterface inMemoryRepo;

    @Autowired
    public WorkerService (@Qualifier ("w") WorkerInMemoryRepoInterface inMemoryRepo) {
        this.inMemoryRepo = inMemoryRepo;
        this.inMemoryRepo.populate();
    }


    public int addService(Worker new_worker)
    {
        return inMemoryRepo.add(new_worker);
    }

    public List<Worker> getWorkersService()
    {
        return inMemoryRepo.getAll();
    }

    public Optional<Worker> getService(UUID id)
    {
        return inMemoryRepo.get(id);
    }

    public int deleteService(UUID id)
    {
        return inMemoryRepo.delete(id);
    }

    public int updateService(UUID id, Worker w)
    {
        return inMemoryRepo.update(id, w);
    }

    public List<Worker> filterService(int salary) { return inMemoryRepo.filterSalary(salary); }
}
