package com.coderoom.cashapp.statement.category;

import com.coderoom.cashapp.wallet.Wallet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class StatementCategory {
    @Id
    @GeneratedValue(generator = "statement_category_sequence_id" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "statement_category_sequence_id", sequenceName = "statement_category_sequence_id", initialValue = 100 , allocationSize = 1)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    public StatementCategory(){}

    @Override
    public String toString(){
        return this.name;
    }
}
