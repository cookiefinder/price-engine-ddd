package com.tw.application.service.command;

import com.tw.domain.rule.Calculator;
import com.tw.domain.rule.Condition;
import com.tw.domain.rule.DiscountCalculator;
import com.tw.domain.rule.DurationCondition;
import com.tw.domain.rule.MoneyOffCalculator;
import com.tw.domain.rule.PriceCondition;
import com.tw.domain.rule.ProductCondition;
import com.tw.domain.rule.ProductSku;
import com.tw.domain.rule.PromotionCode;
import com.tw.domain.rule.Rule;
import com.tw.domain.rule.RuleId;
import com.tw.domain.rule.RuleType;
import com.tw.domain.rule.VipCondition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRuleCommand {
    private String name;
    private String description;
    private RuleType type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isVip;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;
    private Set<String> productSkus;
    private BigDecimal discount;
    private BigDecimal amountLimit;
    private BigDecimal freeAmount;

    public Rule toRule() {
        RuleId ruleId = new RuleId();
        List<Condition> conditions = new ArrayList<>();
        List<Calculator> calculators = new ArrayList<>();
        if (Objects.nonNull(startTime) && Objects.nonNull(endTime)) {
            conditions.add(new DurationCondition(startTime, endTime));
        }
        conditions.add(new VipCondition(isVip));
        if (Objects.nonNull(maxPrice) && Objects.nonNull(minPrice)) {
            conditions.add(new PriceCondition(maxPrice, minPrice));
        }
        if (!CollectionUtils.isEmpty(productSkus)) {
            conditions.add(new ProductCondition(productSkus.stream().map(ProductSku::new).collect(Collectors.toSet())));
        }
        if (Objects.nonNull(discount)) {
            calculators.add(new DiscountCalculator(discount));
        }
        if (Objects.nonNull(amountLimit) && Objects.nonNull(freeAmount)) {
            calculators.add(new MoneyOffCalculator(amountLimit, freeAmount));
        }
        if (Objects.equals(type, RuleType.GENERAL)) {
            return new Rule(ruleId, null, name, description, type, conditions, calculators);
        } else if (Objects.equals(type, RuleType.PROMOTION)) {
            PromotionCode promotionCode = new PromotionCode();
            return new Rule(ruleId, promotionCode, name, description, type, conditions, calculators);
        }
        return null;
    }
}
