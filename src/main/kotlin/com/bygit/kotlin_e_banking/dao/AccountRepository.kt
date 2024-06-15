package com.bygit.kotlin_e_banking.dao

import com.bygit.kotlin_e_banking.modeles.BankAccount
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<BankAccount, Long>