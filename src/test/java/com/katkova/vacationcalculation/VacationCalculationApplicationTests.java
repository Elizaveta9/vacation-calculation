package com.katkova.vacationcalculation;

import com.katkova.vacationcalculation.dto.CalculationDto;
import com.katkova.vacationcalculation.dto.CalculationResultDto;
import com.katkova.vacationcalculation.service.CalculationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class VacationCalculationApplicationTests {
    CalculationService service = new CalculationService();

    @Test
    @DisplayName("Вычисление отпускных")
    void calculateTest() {
        CalculationDto calculations = new CalculationDto(50000.0, 10, LocalDate.parse("2024-03-28"));

        CalculationResultDto result = service.calculate(calculations);

        Assertions.assertEquals(11945.39, result.getResult());
    }

    @Test
    @DisplayName("Вычисление отпускных если указано 0 дней")
    void calculate0daysTest() {
        CalculationDto calculations = new CalculationDto(50000.0, 0, LocalDate.parse("2024-03-28"));

        CalculationResultDto result = service.calculate(calculations);

        Assertions.assertEquals(0.0, result.getResult());
    }

    @Test
    @DisplayName("Вычисление отпускных c праздником")
    void calculateWithHolidayTest() {
        CalculationDto calculations = new CalculationDto(50000.0, 7, LocalDate.parse("2024-05-07"));

        CalculationResultDto result = service.calculate(calculations);

        Assertions.assertEquals(6825.94, result.getResult());
    }

    @Test
    @DisplayName("Вычисление для дат другого года")
    void calculateDifferentYearTest() {
        CalculationDto calculations = new CalculationDto(50000.0, 7, LocalDate.parse("2025-05-07"));

        CalculationResultDto result = service.calculate(calculations);

        Assertions.assertEquals(6825.94, result.getResult());
    }

}
