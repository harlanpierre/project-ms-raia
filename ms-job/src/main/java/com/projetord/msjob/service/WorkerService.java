package com.projetord.msjob.service;

import com.projetord.msjob.entities.Worker;
import com.projetord.msjob.exception.InternalServerErrorException;
import com.projetord.msjob.mapper.WorkerMapper;
import com.projetord.msjob.repositories.WorkerRepository;
import com.projetord.msjob.requests.WorkerPostRequestBody;
import com.projetord.msjob.requests.WorkerPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<Worker> listAll() {
        return workerRepository.findAll();
    }

    public List<Worker> findByName(String name) {
        return workerRepository.findByName(name);
    }

    public Worker findByIdOrThrowInternalServerErrorException(Long id) {
        return workerRepository.findById(id)
                .orElseThrow(() -> new InternalServerErrorException("Worker not Found"));
    }

    public Worker save(WorkerPostRequestBody workerPostRequestBody) {
        return workerRepository.save(WorkerMapper.INSTANCE.toWorker(workerPostRequestBody));
    }

    public void delete(Long id) {
        workerRepository.delete(findByIdOrThrowInternalServerErrorException(id));
    }

    public void update(WorkerPutRequestBody workerPutRequestBody) {
        Worker savedWorker = findByIdOrThrowInternalServerErrorException(workerPutRequestBody.getId());
        Worker worker = WorkerMapper.INSTANCE.toWorker(workerPutRequestBody);
        worker.setId(savedWorker.getId());

        workerRepository.save(worker);
    }
}
