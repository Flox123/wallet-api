package com.coderoom.cashapp.statement.category;

import com.coderoom.cashapp.wallet.Wallet;
import com.coderoom.cashapp.wallet.WalletService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementCategoryService {

    private final StatementCategoryRepository statementCategoryRepository;
    private final WalletService walletService;

    public StatementCategoryService(StatementCategoryRepository statementCategoryRepository,
                                    WalletService walletService){
        this.statementCategoryRepository = statementCategoryRepository;
        this.walletService = walletService;
    }

    public List<StatementCategory> findAll(Long walletId){
        Wallet wallet = walletService.findWalletById(walletId);
        return statementCategoryRepository.findByWalletId(wallet.getId());
    }

    public StatementCategory insertStatementCategory(Long walletId , String categoryName){
        StatementCategory statementCategory = new StatementCategory();
        statementCategory.setName(categoryName);
        statementCategory.setWallet(walletService.findWalletById(walletId));
        return statementCategoryRepository.save(statementCategory);
    }

    public List<StatementCategory> findByName(String name){
        return statementCategoryRepository.findByName(name);
    }

}
