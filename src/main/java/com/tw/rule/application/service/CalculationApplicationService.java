package com.tw.rule.application.service;

import com.tw.rule.application.command.CalculateOrderCommand;
import com.tw.rule.application.presentation.CalculationPresentation;
import org.springframework.stereotype.Service;

@Service
public class CalculationApplicationService {

    public CalculationPresentation calculate(CalculateOrderCommand command, String code) {
        return null;
    }
}
