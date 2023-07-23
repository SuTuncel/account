package com.assestmentDev.account.dto;

import com.assestmentDev.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from) {
        return new TransactionDto(from.getId(),
                from.getTranactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }

}
