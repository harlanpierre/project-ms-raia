package com.projetord.msjob.requests;

import lombok.Data;

@Data
public class WorkerPutRequestBody {
    private Long id;
    private String name;
    private Double dailyIncome;
}
