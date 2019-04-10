package com.build.tools.training.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class User {
    private String name;
    private String address;
    private Integer age;
}
