package com.katkova.vacationcalculation;

import com.katkova.vacationcalculation.dto.CalculationDto;
import com.katkova.vacationcalculation.dto.CalculationResultDto;
import com.katkova.vacationcalculation.service.CalculationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class VacationCalculationApplicationTests {

    @Test
    @DisplayName("Вычисление отпускных")
    void calculateTest() {
        CalculationService service = new CalculationService();
        CalculationDto calculations = new CalculationDto(50000.0, 10, LocalDate.of(2024, 3, 28));

        CalculationResultDto result = service.calculate(calculations);

        Assertions.assertEquals(11945.39, result.getResult());
    }

    @Test
    @DisplayName("Вычисление отпускных если указано 0 дней")
    void calculate0daysTest() {
        CalculationService service = new CalculationService();
        CalculationDto calculations = new CalculationDto(50000.0, 0, LocalDate.of(2024, 3, 28));

        CalculationResultDto result = service.calculate(calculations);

        Assertions.assertEquals(0.0, result.getResult());
    }

}
