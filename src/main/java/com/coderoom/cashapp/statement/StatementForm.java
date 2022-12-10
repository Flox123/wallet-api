package com.coderoom.cashapp.statement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StatementForm {
    @NotNull(message = "The Amount is required")
    private Double amount;

    @NotNull(message = "The City is required")
    private LocalDate date;

    @NotNull(message = "The Category Name is required")
    @NotBlank(message = "The Category Name must not be blanl")
    private String categoryName;

    @NotNull(message = "Type is required")
    @Min(value = 1 , message = "Type must be beetween 1 and 2.")
    @Max(value = 2 , message = "Type must be beetween 1 and 2.")
    private Integer type;
    @NotNull(message = "The Wallet id is required")
    private Long walletId;
}
