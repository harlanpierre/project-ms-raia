package com.projetord.msjob.controller;

import com.projetord.msjob.entities.Worker;
import com.projetord.msjob.requests.WorkerPostRequestBody;
import com.projetord.msjob.requests.WorkerPutRequestBody;
import com.projetord.msjob.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;
    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(workerService.listAll()) ;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        return ResponseEntity.ok(workerService.findByIdOrThrowInternalServerErrorException(id)) ;
    }

    @PostMapping
    public ResponseEntity<Worker> save(@RequestBody WorkerPostRequestBody workerPostRequestBody) {
        return new ResponseEntity<>(workerService.save(workerPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody WorkerPutRequestBody workerPutRequestBody) {
        workerService.update(workerPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
