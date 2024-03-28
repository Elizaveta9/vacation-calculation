package com.katkova.vacationcalculation.service;

import com.katkova.vacationcalculation.dto.CalculationDto;
import com.katkova.vacationcalculation.dto.CalculationResultDto;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CalculationService {
    private LocalDate[] holidaysArr = {
            LocalDate.parse("2024-01-01"),
            LocalDate.parse("2024-01-02"),
            LocalDate.parse("2024-01-03"),
            LocalDate.parse("2024-01-04"),
            LocalDate.parse("2024-01-05"),
            LocalDate.parse("2024-01-06"),
            LocalDate.parse("2024-01-07"),
            LocalDate.parse("2024-01-08"),
            LocalDate.parse("2024-02-23"),
            LocalDate.parse("2024-03-08"),
            LocalDate.parse("2024-05-01"),
            LocalDate.parse("2024-05-09"),
            LocalDate.parse("2024-06-12"),
            LocalDate.parse("2024-11-04")
    };
    private Set<LocalDate> holidaysSet = new HashSet<>(List.of(holidaysArr));

    public CalculationResultDto calculate(CalculationDto calculationDto) {
        LocalDate firstDay = calculationDto.getFirstVacationDay();
        int days = 0;
        for (int i = 0; i < calculationDto.getVacationDays(); i++) {
            LocalDate currentDay = firstDay.plusDays(i);
            if (currentDay.getDayOfWeek() != DayOfWeek.SATURDAY &&
                    currentDay.getDayOfWeek() != DayOfWeek.SUNDAY &&
                    holidaysSet.stream().noneMatch(t ->
                            t.getDayOfMonth() == currentDay.getDayOfMonth() &&
                                    t.getMonth() == currentDay.getMonth()
                    )
            ) {
                days++;
            }
        }
        double result = calculationDto.getAvgSalary() / 29.3 * days;
        return new CalculationResultDto(Math.round(result * 100) / 100.00);
    }

}
