package com.bygit.kotlin_e_banking.modeles

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class BankAccount(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var accountNumber: String = "",
    var accountHolderName: String = "",
    var balance: Double = 0.0
)