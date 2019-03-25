package com.build.tools.training.dependencies;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Footpring {

    private Instant timestamp;

    private String serviceName;
}
