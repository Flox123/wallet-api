package com.coderoom.cashapp.statement;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/statement")
public class StatementController {

    private StatementService statementService;

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @GetMapping
    public List<StatementResponse> findAll(@RequestParam(name = "wallet") Long walletId) {
        return statementService.findAll(walletId).stream()
                .map(statement -> StatementResponse.builder()
                        .id(statement.getId())
                        .amount(statement.getAmount())
                        .categoryName(statement.getStatementCategory().getName())
                        .date(statement.getDate())
                        .type(statement.getType())
                        .build())
                .collect(Collectors.toList());
    }

    @PostMapping
    public StatementResponse createNewStatement(@Valid @RequestBody StatementForm statementRequest){
        Statement statement = statementService.insertStatement(statementRequest);
        return StatementResponse.builder()
                .id(statement.getId())
                .date(statement.getDate())
                .amount(statement.getAmount())
                .type(statement.getType())
                .categoryName(statement.getStatementCategory().getName())
                .build();

    }
}
