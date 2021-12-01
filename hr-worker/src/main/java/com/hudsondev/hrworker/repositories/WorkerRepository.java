package com.hudsondev.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hudsondev.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{
	
}
