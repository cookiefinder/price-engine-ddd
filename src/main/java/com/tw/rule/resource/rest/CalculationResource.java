package com.tw.rule.resource.rest;

import com.tw.rule.application.command.CalculateOrderCommand;
import com.tw.rule.application.presentation.CalculationPresentation;
import com.tw.rule.application.service.CalculationApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculation")
@RequiredArgsConstructor
public class CalculationResource {
    private final CalculationApplicationService calculationApplicationService;

    @PostMapping
    public CalculationPresentation calculate(@RequestBody CalculateOrderCommand command,
                                             @RequestParam String code) {
        return calculationApplicationService.calculate(command, code);
    }
}
