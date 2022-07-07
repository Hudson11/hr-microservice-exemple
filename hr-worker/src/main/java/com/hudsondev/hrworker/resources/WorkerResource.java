package com.hudsondev.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hudsondev.hrworker.dto.WorkerCreateDTO;
import com.hudsondev.hrworker.entities.Worker;
import com.hudsondev.hrworker.repositories.WorkerRepository;
import com.hudsondev.hrworker.services.WorkerService;

import javassist.NotFoundException;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository workerRepository;
	
	@Autowired
	private WorkerService workerService;
	
	@Autowired
	private Environment env;
	
	private Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workers = this.workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) throws NotFoundException {
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker worker = this.workerRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found"));
		return ResponseEntity.ok(worker);	

	}
	
	@PostMapping
	public ResponseEntity<Worker> save (@RequestBody WorkerCreateDTO worker){
		return new ResponseEntity<Worker>(this.workerService.saveWorker(worker), HttpStatus.CREATED);
	}
	
}
