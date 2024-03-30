package com.hibernate.hibernate.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {
    private String name;
    private String lastname;
}
