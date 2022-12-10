package com.coderoom.cashapp.statement;

import com.coderoom.cashapp.statement.category.StatementCategory;
import com.coderoom.cashapp.statement.category.StatementCategoryService;
import com.coderoom.cashapp.wallet.Wallet;
import com.coderoom.cashapp.wallet.WalletService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementService {

    private final StatementRepository statementRepository;
    private final WalletService walletService;
    private final StatementCategoryService statementCategoryService;

    public StatementService(StatementRepository statementRepository, WalletService walletService , StatementCategoryService statementCategoryService) {
        this.statementRepository = statementRepository;
        this.walletService = walletService;
        this.statementCategoryService = statementCategoryService;
    }

    public List<Statement> findAll(Long walletId) {
      return statementRepository.findByWalletId(walletId);
    }

    public Statement insertStatement(StatementForm statementRequest){
        Wallet wallet = walletService.findWalletById(statementRequest.getWalletId());
        StatementCategory statementCategory = statementCategoryService
                .findByName(statementRequest.getCategoryName())
                .stream()
                .findFirst()
                .orElseGet(() -> statementCategoryService.insertStatementCategory(wallet.getId(), statementRequest.getCategoryName()));

        Statement statement = new Statement();
        statement.setWallet(wallet);
        statement.setAmount(statementRequest.getAmount());
        statement.setType(statementRequest.getType());
        statement.setDate(statementRequest.getDate());
        statement.setStatementCategory(statementCategory);
        return statementRepository.save(statement);
    }

}
