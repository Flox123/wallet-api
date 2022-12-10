package com.coderoom.cashapp.statement;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StatementRepository extends PagingAndSortingRepository<Statement, Long> {
   List<Statement> findByWalletId(Long walletId);
}
