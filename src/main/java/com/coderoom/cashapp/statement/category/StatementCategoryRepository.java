package com.coderoom.cashapp.statement.category;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StatementCategoryRepository  extends PagingAndSortingRepository<StatementCategory , Long> {
    List<StatementCategory> findByWalletId(Long walletId);
    List<StatementCategory> findByName(String name);
}
