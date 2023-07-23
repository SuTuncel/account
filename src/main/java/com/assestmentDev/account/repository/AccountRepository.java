package com.assestmentDev.account.repository;

import com.assestmentDev.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
