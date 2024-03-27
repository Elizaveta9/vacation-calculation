package com.katkova.vacationcalculation.service;

import com.katkova.vacationcalculation.dto.CalculationDto;
import com.katkova.vacationcalculation.dto.CalculationResultDto;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    public CalculationResultDto calculate(CalculationDto calculationDto) {
        double result = calculationDto.getAvgSalary() / 29.3 * calculationDto.getVacationDays();
        return new CalculationResultDto(Math.round(result * 100) / 100.00);
    }
}
