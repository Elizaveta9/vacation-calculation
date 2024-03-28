package com.katkova.vacationcalculation.service;

import com.katkova.vacationcalculation.dto.CalculationDto;
import com.katkova.vacationcalculation.dto.CalculationResultDto;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class CalculationService {
    public CalculationResultDto calculate(CalculationDto calculationDto) {
        LocalDate firstDay = calculationDto.getFirstVacationDay();
        int days = 0;
        for (int i = 0; i < calculationDto.getVacationDays(); i++) {
            if (firstDay.plusDays(i).getDayOfWeek() != DayOfWeek.SATURDAY &&
                    firstDay.plusDays(i).getDayOfWeek() != DayOfWeek.SUNDAY) {
                days++;
            }
        }
        System.out.println(days);
        double result = calculationDto.getAvgSalary() / 29.3 * days;
        return new CalculationResultDto(Math.round(result * 100) / 100.00);
    }
}
