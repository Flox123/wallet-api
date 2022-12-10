package com.coderoom.cashapp.wallet;

import com.coderoom.cashapp.statement.Statement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Getter
@Setter
public class Wallet {
    @Id
    @GeneratedValue(generator = "wallet_id" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "wallet_id", sequenceName = "wallet_id", initialValue = 1 , allocationSize = 1)
    private Long id;
    @NotBlank
    private String name;
    @OneToMany(fetch = FetchType.EAGER , mappedBy = "wallet" )
    private Set<Statement> statements;
}
