package com.coderoom.cashapp.wallet;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface WalletRepository extends PagingAndSortingRepository<Wallet , Long> {
    List<Wallet> findAll();
}
