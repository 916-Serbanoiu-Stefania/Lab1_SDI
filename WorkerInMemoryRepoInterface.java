package com.example.demo.In_MemoryRepo;

import com.example.demo.Model.Worker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WorkerInMemoryRepoInterface {
    void populate();

    List<Worker> getAll();

    Optional<Worker> get(UUID id);

    int add(Worker worker);

    int delete(UUID id);

    int update(UUID id, Worker worker);

    List<Worker> filterSalary(int salary);
}
