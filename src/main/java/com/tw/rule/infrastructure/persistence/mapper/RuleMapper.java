package com.tw.rule.infrastructure.persistence.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.rule.domain.model.PromotionCode;
import com.tw.rule.domain.model.Rule;
import com.tw.rule.domain.model.RuleId;
import com.tw.rule.infrastructure.persistence.exception.MapperException;
import com.tw.rule.infrastructure.persistence.po.RulePo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static java.util.Optional.ofNullable;

@Component
@RequiredArgsConstructor
public class RuleMapper {
    private final ObjectMapper objectMapper;

    public RulePo toPo(Rule rule) {
        try {
            if (Objects.isNull(rule)) {
                return null;
            }
            return new RulePo(rule.getId().getId(),
                    ofNullable(rule.getCode()).map(PromotionCode::getCode).orElse(null),
                    rule.getName(),
                    rule.getDescription(),
                    rule.getType(),
                    objectMapper.writeValueAsString(rule.getCondition()),
                    objectMapper.writeValueAsString(rule.getCalculator()),
                    rule.getActive());
        } catch (JsonProcessingException e) {
            throw new MapperException(e.getMessage(), e);
        }
    }

    public Rule toModel(RulePo rulePo) {
        try {
            if (Objects.isNull(rulePo)) {
                return null;
            }
            return new Rule(new RuleId(rulePo.getId()),
                    new PromotionCode(rulePo.getCode()),
                    rulePo.getName(),
                    rulePo.getDescription(),
                    rulePo.getType(),
                    objectMapper.readValue(rulePo.getCondition(), new TypeReference<>() {
                    }),
                    objectMapper.readValue(rulePo.getCalculator(), new TypeReference<>() {
                    }),
                    rulePo.getActive());
        } catch (JsonProcessingException e) {
            throw new MapperException(e.getMessage(), e);
        }
    }
}
