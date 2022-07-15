package com.tw.rule.application.presentation;

import com.tw.rule.domain.model.Rule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RulePagePresentation {
    private Integer totalPage;
    private Integer pageIndex;
    private Integer pageSize;
    private Long totalSize;
    private List<RulePresentation> data;

    public static RulePagePresentation from(Page<Rule> rulePage) {
        return new RulePagePresentation(rulePage.getTotalPages(),
                rulePage.getNumber(),
                rulePage.getSize(),
                rulePage.getTotalElements(),
                rulePage.getContent().stream().map(RulePresentation::from).collect(Collectors.toList()));
    }
}
