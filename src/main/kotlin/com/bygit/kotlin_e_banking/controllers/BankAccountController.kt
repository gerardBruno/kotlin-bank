package com.bygit.kotlin_e_banking.controllers

import com.bygit.kotlin_e_banking.modeles.BankAccount
import com.bygit.kotlin_e_banking.services.AccountService
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/accounts")
class BankAccountController(private val bankService: AccountService) {

    @GetMapping("")
    fun getAllAccounts(): ResponseEntity<List<BankAccount>> {
        val accounts = bankService.getAllAccounts()
        return ResponseEntity.ok(accounts)
    }

    @GetMapping("/{id}")
    fun getAccountById(@PathVariable id: Long): ResponseEntity<BankAccount> {
        val account = bankService.getAccountById(id)
        return ResponseEntity.ok(account)
    }

    @PostMapping("")
    fun createAccount(@RequestBody account: BankAccount): ResponseEntity<BankAccount> {
        val createdAccount = bankService.createAccount(account)
        return ResponseEntity.ok(createdAccount)
    }

    @PutMapping("/{id}")
    fun updateAccount(@PathVariable id: Long, @RequestBody account: BankAccount): ResponseEntity<BankAccount> {
        val updatedAccount = bankService.updateAccount(id, account)
        return ResponseEntity.ok(updatedAccount)
    }

    @DeleteMapping("/{id}")
    fun deleteAccount(@PathVariable id: Long): ResponseEntity<Void> {
        bankService.deleteAccount(id)
        return ResponseEntity.noContent().build()
    }
}

