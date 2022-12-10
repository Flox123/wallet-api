package com.coderoom.cashapp.statement;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class StatementResponse {
    private Long id;
    private Double amount;
    private LocalDate date;
    private Integer type;
    private String categoryName;
}
