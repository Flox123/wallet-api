package com.coderoom.cashapp.statement.category;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/statement/category")
public class StatementCategoryController {

    private StatementCategoryService statementCategoryService;

    public StatementCategoryController(StatementCategoryService statementCategoryService){
        this.statementCategoryService = statementCategoryService;
    }

    @GetMapping
    public List<StatementCategoryResponse> findAll(@RequestParam(name = "wallet") Long walletId){
        List<StatementCategory> statementCategories = statementCategoryService.findAll(walletId);
        return statementCategories.stream()
                .map(statementCategory -> StatementCategoryResponse.builder()
                .id(statementCategory.getId())
                .name(statementCategory.getName())
                .build()).collect(Collectors.toList());
    }

    @PostMapping
    public StatementCategoryResponse createNewCategory(@RequestParam(name = "wallet") Long walletId,@RequestParam(name = "category") String category){
        StatementCategory statementCategory = statementCategoryService.insertStatementCategory(walletId , category);
        return StatementCategoryResponse.builder()
                .id(statementCategory.getId())
                .name(statementCategory.getName())
                .build();
    }
}
