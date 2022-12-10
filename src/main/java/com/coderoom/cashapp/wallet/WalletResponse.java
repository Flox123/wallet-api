package com.coderoom.cashapp.wallet;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class WalletResponse {
    private Long id;
    private String name;
}
