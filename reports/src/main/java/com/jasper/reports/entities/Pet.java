package com.jasper.reports.entities;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pet {
    @Min(1)
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    private Date birthday;

    @NotBlank
    private String breed;
}
