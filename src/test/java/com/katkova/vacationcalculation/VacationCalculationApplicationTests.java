package com.katkova.vacationcalculation;

import com.katkova.vacationcalculation.dto.CalculationDto;
import com.katkova.vacationcalculation.dto.CalculationResultDto;
import com.katkova.vacationcalculation.service.CalculationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VacationCalculationApplicationTests {

	@Test
	@DisplayName("Вычисление отпускных")
	void calculateTest() {
		CalculationService service = new CalculationService();
		CalculationDto calculations = new CalculationDto(50000.0, 10);

		CalculationResultDto result = service.calculate(calculations);

		Assertions.assertEquals(17064.85, result.getResult());
	}

}
