package com.projetord.msjob.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_worker")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;
}
