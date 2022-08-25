package com.projetord.msjob.repositories;

import com.projetord.msjob.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    List<Worker> findByName(String name);
}
