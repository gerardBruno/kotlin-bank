package com.bygit.kotlin_e_banking.services

import com.bygit.kotlin_e_banking.dao.AccountRepository
import com.bygit.kotlin_e_banking.modeles.BankAccount
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service


@Service
class AccountService(private val bankRepository: AccountRepository) {

    fun getAllAccounts(): List<BankAccount> {
        return bankRepository.findAll()
    }

    fun getAccountById(id: Long): BankAccount {
        return bankRepository.findById(id).orElseThrow { EntityNotFoundException("Bank account not found for id: $id") }
    }

    fun createAccount(account: BankAccount): BankAccount {
        return bankRepository.save(account)
    }

    fun updateAccount(id: Long, updatedAccount: BankAccount): BankAccount {
        val existingAccount = getAccountById(id)
        if (existingAccount != null) {
            // MAJ les champs nécessaires
            existingAccount.accountHolderName = updatedAccount.accountHolderName
            existingAccount.balance = updatedAccount.balance
        }
        return bankRepository.save(existingAccount)
    }

    fun deleteAccount(id: Long) {
        bankRepository.deleteById(id)
    }
}