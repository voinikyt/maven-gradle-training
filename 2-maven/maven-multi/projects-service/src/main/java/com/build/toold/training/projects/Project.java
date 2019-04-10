package com.build.toold.training.projects;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Project {
    private String name;
    private BigDecimal budget;
}
