package com.coderoom.cashapp.statement;

import com.coderoom.cashapp.statement.category.StatementCategory;
import com.coderoom.cashapp.wallet.Wallet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
public class Statement {
    @Id
    @GeneratedValue(generator = "statement_sequence_id" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "statement_sequence_id", sequenceName = "statement_sequence_id", initialValue = 100 , allocationSize = 1)
    private Long id;
    private Double amount;
    private LocalDate date;
    private Integer type;
    @OneToOne(fetch = FetchType.LAZY)
    private StatementCategory statementCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
