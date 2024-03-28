package com.katkova.vacationcalculation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class CalculationResultDto {
    private Double result;
}
