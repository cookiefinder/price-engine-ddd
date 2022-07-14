package com.tw.rule.infrastructure.persistence.po;

import com.tw.rule.domain.model.RuleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "rule")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RulePo {
    @Id
    private Long id;
    private String code;
    private String name;
    private String description;
    private RuleType type;
    @Column(name = "`condition`")
    private String condition;
    private String calculator;
    private Boolean active;
}
