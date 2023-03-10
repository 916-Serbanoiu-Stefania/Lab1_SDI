package com.example.demo.In_MemoryRepo;

import com.example.demo.Model.Worker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("w")
public class WorkerRepository implements WorkerInMemoryRepoInterface {
    private static final List<Worker> workers = new ArrayList<>();


    @Override
    public void populate()
    {
        UUID id = UUID.randomUUID();
        this.add(new Worker(id,"Vasile", "Popescu", 30, "sdfsf", "male", 5000));
        id = UUID.randomUUID();
        this.add(new Worker(id,"Ion", "Vasilescu", 50, "sfssfddfs", "male", 5500));
    }
    public int add(Worker worker)
    {
        UUID new_id = UUID.randomUUID();
        workers.add(new Worker(new_id, worker.getFirstName(), worker.getLastName(), worker.getAge(), worker.getEmail(), worker.getGender(), worker.getSalary()));
        return 0;
    }

    @Override
    public int delete(UUID id)
    {
        Optional<Worker> w = get(id);
        if(w.isEmpty())
        {
            return 0;
        }
        workers.remove(w.get());
        return 1;
    }

    @Override
    public int update(UUID id, Worker worker)
    {
        Optional<Worker> w = get(id);
        if(w.isEmpty())
        {
            return -1;
        }
        w.get().setFirstName(worker.getFirstName());
        w.get().setLastName(worker.getLastName());
        w.get().setAge(worker.getAge());
        w.get().setEmail(worker.getEmail());
        w.get().setGender(worker.getGender());
        w.get().setSalary(worker.getSalary());
        return 1;
    }

    @Override
    public List<Worker> filterSalary(int salary)
            // filters all workers with salary bigger than 'salary' variable
    {
        return workers.stream().filter(worker -> worker.getSalary() > salary).collect(Collectors.toList());
    }

    @Override
    public Optional<Worker> get(UUID id)
    {
       return workers.stream().filter(w -> w.getId().equals(id)).findFirst();
    }
    @Override
    public List<Worker> getAll()
    {
        return workers;
    }
}
