package com.tw.api;

import com.tw.application.service.PriceEngineApplicationService;
import com.tw.application.service.command.CreateRuleCommand;
import com.tw.application.service.representation.RuleRepresentation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/price-engine/api")
@RequiredArgsConstructor
public class PriceEngineController {
    private final PriceEngineApplicationService priceEngineApplicationService;

    @PostMapping("/rules")
    public RuleRepresentation createRule(CreateRuleCommand command) {
        return priceEngineApplicationService.createRule(command);
    }
}
