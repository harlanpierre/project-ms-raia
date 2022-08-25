package com.projetord.msjob.controller;

import com.projetord.msjob.service.WorkerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class WorkerControllerTest {
    @InjectMocks
    private WorkerController workerController;
    @Mock
    private WorkerService workerServiceMock;
    @Test
    void test() {

    }

}