package com.hudsondev.hrworker.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hudsondev.hrworker.dto.WorkerCreateDTO;
import com.hudsondev.hrworker.entities.Worker;
import com.hudsondev.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {
	
	@Autowired
	private WorkerRepository repository;
	
	public Worker saveWorker (WorkerCreateDTO workerDto) {
		Worker worker = new Worker();
		worker.setName(workerDto.getName());
		worker.setDailyIncome(workerDto.getDailyIncome());
		return this.repository.save(worker);
	}
	
	public Optional<Worker> findWorkerById (Long id) {
		Optional<Worker> worker = this.repository.findById(id);
		return worker;
	}

}
