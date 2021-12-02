package controllers;

import exceptions.AccountNotFoundException;
import models.account;
import repositories.accountRepository;
import org.springframework.web.bind.annotation.*;
@RestController
public class AccountController {
    private final accountRepository accountRepository;
    public AccountController(accountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @GetMapping("/accounts/{username}")
    account getAccount(@PathVariable String username){
        return accountRepository.findById(username)
                .orElseThrow(() -> new AccountNotFoundException("No se encontro una cuenta con el username: " + username));
    }
    @PostMapping("/accounts")
    account newAccount(@RequestBody account account){
        return accountRepository.save(account);
    }
}