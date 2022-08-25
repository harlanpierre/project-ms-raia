package com.projetord.msjob.mapper;

import com.projetord.msjob.entities.Worker;
import com.projetord.msjob.requests.WorkerPostRequestBody;
import com.projetord.msjob.requests.WorkerPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class WorkerMapper {
    public static final WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);
    public abstract Worker toWorker(WorkerPostRequestBody workerPostRequestBody);

    public abstract Worker toWorker(WorkerPutRequestBody workerPutRequestBody);
}
