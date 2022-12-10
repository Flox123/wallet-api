package com.coderoom.cashapp.config;

import com.coderoom.cashapp.statement.StatementRepository;
import com.coderoom.cashapp.statement.category.StatementCategoryRepository;
import com.coderoom.cashapp.wallet.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private StatementCategoryRepository statementCategoryRepository;

    @Autowired
    private StatementRepository statementRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
       /* Wallet wallet = walletRepository.findAllWithFetcheStatements().get(0);

        Statement statement = statementRepository.findAllFetchWallet().get(0);

        System.out.println(wallet.getStatements());
        System.out.println(statement.getWallet());*/
    }
}
