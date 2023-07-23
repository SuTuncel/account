package com.assestmentDev.account.dto

import com.assestmentDev.account.model.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(
        val id: String?,
        val balance: BigDecimal?,
        val creationDate: LocalDateTime?,
        val customer: AccountCustomerDto?,
        val transactions: Set<TransactionDto>?
)
