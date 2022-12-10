package com.coderoom.cashapp.statement.category;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class StatementCategoryResponse {
    private Long id;
    private String name;
}
