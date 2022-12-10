package com.coderoom.cashapp.wallet;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@NoArgsConstructor
public class WalletForm {
    @NotBlank(message = "The name is required")
    private String name;
}
