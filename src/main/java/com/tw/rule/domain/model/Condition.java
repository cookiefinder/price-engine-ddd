package com.tw.rule.domain.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXISTING_PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@Getter
@Setter
@JsonTypeInfo(use = NAME ,property = "type", visible = true, include = EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AndCondition.class, name = "AND"),
        @JsonSubTypes.Type(value = DurationCondition.class, name = "DURATION"),
        @JsonSubTypes.Type(value = PriceCondition.class, name = "PRICE"),
        @JsonSubTypes.Type(value = ProductCondition.class, name = "PRODUCT"),
        @JsonSubTypes.Type(value = VipCondition.class, name = "VIP")
})
public abstract class Condition {
    protected ConditionType type;
    abstract boolean applicable(Order order);
}