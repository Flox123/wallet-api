package com.coderoom.cashapp.wallet;

import com.coderoom.cashapp.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    protected List<Wallet> findAllWallet(){
        return walletRepository.findAll();
    }

    public Wallet findWalletById(Long walletId){
        Optional<Wallet> wallet = walletRepository.findById(walletId);
        return wallet.orElseThrow(() -> new EntityNotFoundException("Wallet with id " + walletId + " not found"));
    }

    protected Wallet saveWallet(String name){
        Wallet wallet = new Wallet();
        wallet.setName(name);
        return walletRepository.save(wallet);
    }



}
