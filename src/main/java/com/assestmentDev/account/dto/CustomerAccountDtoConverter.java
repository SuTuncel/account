package com.assestmentDev.account.dto;

import com.assestmentDev.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerAccountDto convert(Account from) {
        return new CustomerAccountDto(from.getId(),
                from.getBalance(),
                from.getTransaction().stream().map(converter::convert).collect(Collectors.toSet()), //for döngüsüne alternatif optional ile if else koşul döngüsünden kuruluyorsun
                from.getCreationDate()
        );
    }
}
