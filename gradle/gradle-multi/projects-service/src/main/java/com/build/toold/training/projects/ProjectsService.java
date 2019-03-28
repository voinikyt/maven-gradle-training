package com.build.toold.training.projects;

import java.math.BigDecimal;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class ProjectsService {

    public Set<Project> getProjects() {
        return ImmutableSet.of(
                Project.builder()
                        .name("Training")
                        .budget(BigDecimal.valueOf(0))
                        .build(),
                Project.builder()
                        .name("RBS")
                        .budget(BigDecimal.valueOf(1e9))
                        .build()
        );
    }

}
