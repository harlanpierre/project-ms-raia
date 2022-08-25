package com.projetord.msjob.requests;

import lombok.Data;

@Data
public class WorkerPostRequestBody {
    private String name;
    private Double dailyIncome;
}
