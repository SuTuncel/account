package com.assestmentDev.account.dto

import com.assestmentDev.account.model.TranactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(
        val id: String?,
        val transactionType: TranactionType? = TranactionType.INITIAL,
        val amount: BigDecimal,
        val transactionDate: LocalDateTime?,
)
