package com.katkova.vacationcalculation.controller;

import com.katkova.vacationcalculation.dto.CalculationDto;
import com.katkova.vacationcalculation.dto.CalculationResultDto;
import com.katkova.vacationcalculation.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private CalculationService service;

    @GetMapping("/calculacte")
    public CalculationResultDto getCalculation(@RequestBody CalculationDto calculationDto) {
        return service.calculate(calculationDto);
    }

}
