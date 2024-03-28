package com.katkova.vacationcalculation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CalculationDto {
    private Double avgSalary;
    private Integer vacationDays;
    private LocalDate firstVacationDay;
}
