package com.assestmentDev.account.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Transaction(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name= "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?,
        val tranactionType: TranactionType? = TranactionType.INITIAL,
        val amount: BigDecimal?,
        val transactionDate: LocalDateTime,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "account_id", nullable = false)
        val account: Account?

) {
    constructor() : this(null, null, BigDecimal.ZERO, LocalDateTime.now(), null)
    constructor(amount: BigDecimal, account: Account): this( "",amount = amount,
            transactionDate = LocalDateTime.now(), tranactionType = TranactionType.INITIAL, account = account)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Transaction

        if (id != other.id) return false
        if (tranactionType != other.tranactionType) return false
        if (amount != other.amount) return false
        if (transactionDate != other.transactionDate) return false
        return account == other.account
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (tranactionType?.hashCode() ?: 0)
        result = 31 * result + (amount?.hashCode() ?: 0)
        result = 31 * result + (transactionDate?.hashCode() ?: 0)
        return result
    }
}

enum class TranactionType {
    INITIAL, TRANSFER
}
