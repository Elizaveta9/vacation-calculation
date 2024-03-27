package com.katkova.vacationcalculation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CalculationDto {
    private Float avgSalary;
    private Integer vacationDays;
}
