package com.katkova.vacationcalculation.service;

import com.katkova.vacationcalculation.dto.CalculationDto;
import com.katkova.vacationcalculation.dto.CalculationResultDto;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    public CalculationResultDto calculate(CalculationDto calculationDto) {
        //логика
        return new CalculationResultDto(calculationDto.getAvgSalary() + calculationDto.getVacationDays());
    }
}
