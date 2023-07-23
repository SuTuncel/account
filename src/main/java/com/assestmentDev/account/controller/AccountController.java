package com.assestmentDev.account.controller;

import com.assestmentDev.account.dto.AccountDto;
import com.assestmentDev.account.dto.CreateAccountRequest;
import com.assestmentDev.account.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@Valid @RequestBody CreateAccountRequest request) { //jsondan bilgi alır
        return ResponseEntity.ok(accountService.createAccount(request));
    }
}
