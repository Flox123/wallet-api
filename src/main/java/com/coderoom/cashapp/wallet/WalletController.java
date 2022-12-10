package com.coderoom.cashapp.wallet;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/wallet")
public class WalletController {

    private WalletService walletService;

    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @GetMapping
    public List<WalletResponse> getWallets(){
        return walletService.findAllWallet().stream()
                .map(wallet -> WalletResponse.builder()
                            .id(wallet.getId())
                            .name(wallet.getName())
                            .build()).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WalletResponse getWalletById(@PathVariable Long id){
        Wallet wallet = walletService.findWalletById(id);
        return WalletResponse.builder()
                .id(wallet.getId())
                .name(wallet.getName())
                .build();
    }

    @PutMapping
    public WalletResponse insertWallet(@Valid @RequestBody WalletForm walletForm){
        Wallet wallet = walletService.saveWallet(walletForm.getName());
        return WalletResponse.builder()
                .id(wallet.getId())
                .name(wallet.getName())
                .build();
    }
}
